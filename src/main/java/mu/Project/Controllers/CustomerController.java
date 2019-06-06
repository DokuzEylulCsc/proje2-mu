package mu.Project.Controllers;

import mu.Project.Logger;
import mu.Project.Models.*;
import mu.Project.Views.CustomerView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomerController extends AccountController {
    final static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public CustomerController(Account model, MainController parent) {
        setModel(model);
        setParent(parent);
        initializeFrame();
    }

    /**
     * Set visible after all components initialized from database.
     */
    private void initializeFrame() {
        setFrame(new CustomerView(this));
        getFrame().setEmailFixedField(getModel().getEmail());
        getFrame().setNameField(getModel().getName());

        // add cities to reservationTab.citiesComboBox
        List<String> cities = Hotel.getDistinctCities();
        getFrame().getCitiesComboBox().addItem("All");
        for (String city : cities) {
            getFrame().getCitiesComboBox().addItem(city);
        }

        refreshReservedTableButtonClicked();
        getFrame().makeFullScreen();
        getFrame().setVisible(true);
    }

    public void searchButtonClicked() {
        try {
            Date startDate = dateFormat.parse((String) getFrame().getStartDateField().getValue());
            Date endDate = dateFormat.parse((String) getFrame().getEndDateField().getValue());
            String city = (String) getFrame().getCitiesComboBox().getSelectedItem();
            Boolean seaView = getFrame().getSeaViewCheckBox().isSelected();
            Boolean safe = getFrame().getSafeCheckBox().isSelected();
            Integer maxBudget = ((Long) getFrame().getBudgetField().getValue()).intValue();
            Integer starCount = (Integer) getFrame().getStarCountSpinner().getValue();
            Integer personCount = (Integer) getFrame().getPersonCountSpinner().getValue();

            DefaultTableModel tableModel = Room.getAvailableRoomsAsTableModel(maxBudget, personCount, seaView, safe, city,
                    starCount, startDate, endDate);

            getFrame().getReservationTable().setModel(tableModel);
            getFrame().getReservationTable().updateUI();

        } catch (ParseException e) {
            getFrame().showInvalidDateFormatAlert();

        } catch (InvalidDateIntervalException e) {
            getFrame().showInvalidDateIntervalAlert();

        } catch (NullPointerException e) {
            getFrame().showEmptyRequiredFieldAlert();
        }
    }

    public void reserveButtonClicked() {
        try {
            int row = getFrame().getReservationTable().getSelectedRow();

            String hotel_name = (String) getFrame().getReservationTable().getValueAt(row, 0);
            Integer room_number = (Integer) getFrame().getReservationTable().getValueAt(row, 4);
            Integer person_count = (Integer) getFrame().getPersonCountSpinner().getValue();
            String startDateString = (String) getFrame().getStartDateField().getValue();
            String endDateString = (String) getFrame().getEndDateField().getValue();

            int confirmation = getFrame().showYesNoOptionPane(
                    String.format("Are you sure you want to reserve room number %d at %s?",
                            room_number, hotel_name)
            );

            if (confirmation == JOptionPane.NO_OPTION || confirmation == JOptionPane.CLOSED_OPTION) {
                Logger.getInstance().addLog(String.format("Aborting reservation request of %s for room %d at %s!",
                        getModel().getEmail(), room_number, hotel_name));
                return;
            }

            Date startDate = dateFormat.parse(startDateString);
            Date endDate = dateFormat.parse(endDateString);
            Reservation.reserveRoom(getModel(), hotel_name, room_number, person_count, startDate, endDate);
            getFrame().showReservationSuccessfulAlert(hotel_name, room_number, startDateString, endDateString);
            searchButtonClicked();
            refreshReservedTableButtonClicked();

        } catch (ParseException e) {
            getFrame().showInvalidDateFormatAlert();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
            getFrame().showGeneralInternalErrorAlert();

        } catch (ArrayIndexOutOfBoundsException e) {
            // row number 0
            getFrame().showNoReservationSelectedAlert();
        }
    }

    public void cancelReservationButtonClicked() {

        try {
            int row = getFrame().getReservedTable().getSelectedRow();

            String startDateString = (String) getFrame().getReservedTable().getValueAt(row, 0);
            String hotel_name = (String) getFrame().getReservedTable().getValueAt(row, 3);
            Integer room_number = (Integer) getFrame().getReservedTable().getValueAt(row, 7);
            Date startDate = dateFormat.parse(startDateString);

            // compare to now, if reservation is in past, don't perform deletion
            if (new Date().compareTo(startDate) >= 0) {
                getFrame().showPastReservationCancelRequestAlert();
                return;
            }

            int confirmation = getFrame().showYesNoOptionPane(
                    String.format("Are you sure you want cancel your reservation for room number %d at %s?",
                            room_number, hotel_name)
            );

            if (confirmation == JOptionPane.NO_OPTION || confirmation == JOptionPane.CLOSED_OPTION) {
                Logger.getInstance().addLog(String.format("Aborting reservation canceling request of %s for room %d at %s",
                        getModel().getEmail(), room_number, hotel_name));
                return;
            }

            Reservation.removeReservation(getModel(), startDate, hotel_name, room_number);
            getFrame().showReservationCancellationSuccessfulAlert(hotel_name, room_number, startDateString);
            refreshReservedTableButtonClicked();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
            getFrame().showGeneralInternalErrorAlert();

        } catch (ParseException e) {
            Logger.getInstance().addLog(e);
            getFrame().showGeneralInternalErrorAlert();

        } catch (ArrayIndexOutOfBoundsException e) {
            // row number 0
            getFrame().showNoRoomSelectedAlert();
        }
    }

    public void refreshReservedTableButtonClicked() {
        String email = getModel().getEmail();
        DefaultTableModel tableModel = Reservation.getReservedRoomsAsTableModel(email, dateFormat);

        getFrame().getReservedTable().setModel(tableModel);
        getFrame().getReservedTable().updateUI();
    }


    public void updateNameButtonClicked() {
        String newName = getFrame().getNameField();

        try {
            getModel().setNewName(newName);
            getFrame().showNameUpdatedAlert();

        } catch (NoSuchAccountException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInternalErrorWhileUpdatingAlert();
        }
    }

    public void updatePasswordButtonClicked() {
        try {
            getModel().setNewPassword(getFrame().getPasswordField());
            Logger.getInstance().addLog("Password changed: " + getModel().getEmail());
            getFrame().showPasswordUpdatedAlert();

        } catch (InvalidPasswordException e) {
            getFrame().showInvalidPasswordAlert();

        } catch (NoSuchAccountException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInternalErrorWhileUpdatingAlert();
        }
    }

    @Override CustomerView getFrame() {
        return (CustomerView) super.getFrame();
    }
}
