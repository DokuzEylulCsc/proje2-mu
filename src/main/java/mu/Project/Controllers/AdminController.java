package mu.Project.Controllers;

import mu.Project.Logger;
import mu.Project.Models.*;
import mu.Project.Views.AdminView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class AdminController extends AccountController {

    public AdminController(Account model, MainController parent) {
        setModel(model);
        setParent(parent);
        initializeFrame();
    }

    private void initializeFrame() {
        setFrame(new AdminView(this));
        getFrame().setNameField(getModel().getName());
        getFrame().setEmailFixedField(getModel().getEmail());

        List<String> cities = Hotel.getDistinctCities();
        getFrame().getCitiesComboBox().addItem("All");
        for (String city : cities) {
            getFrame().getCitiesComboBox().addItem(city);
        }

        getFrame().makeFullScreen();
        getFrame().setVisible(true);
    }

    public void searchButtonClicked() {
        try {
            Date startDate = CustomerController.dateFormat.parse((String) getFrame().getStartDateField().getValue());
            Date endDate = CustomerController.dateFormat.parse((String) getFrame().getEndDateField().getValue());
            String city = (String) getFrame().getCitiesComboBox().getSelectedItem();

            DefaultTableModel tableModel = Reservation.getAllReservedRoomsAsTableModel(startDate, endDate, city, CustomerController.dateFormat);

            getFrame().getSummaryTable().setModel(tableModel);
            getFrame().getSummaryTable().updateUI();

        } catch (ParseException e) {
            getFrame().showInvalidDateFormatAlert();

        } catch (InvalidDateIntervalException e) {
            getFrame().showInvalidDateIntervalAlert();

        } catch (NullPointerException e) {
            getFrame().showEmptyRequiredFieldAlert();
        }
    }

    public void cancelReservationButtonClicked() {

        try {
            int row = getFrame().getSummaryTable().getSelectedRow();

            String startDateString = (String) getFrame().getSummaryTable().getValueAt(row, 0);
            String email = (String) getFrame().getSummaryTable().getValueAt(row, 2);
            String hotel_name = (String) getFrame().getSummaryTable().getValueAt(row, 4);
            Integer room_number = (Integer) getFrame().getSummaryTable().getValueAt(row, 8);
            Date startDate = CustomerController.dateFormat.parse(startDateString);

            // compare to now, if reservation is in past, don't perform deletion
            if (new Date().compareTo(startDate) >= 0) {
                getFrame().showPastReservationCancelRequestAlert();
                return;
            }

            int confirmation = getFrame().showYesNoOptionPane(
                    String.format("Are you sure you want cancel %s's reservation for room number %d at %s?",
                            email, room_number, hotel_name)
            );

            if (confirmation == JOptionPane.NO_OPTION || confirmation == JOptionPane.CLOSED_OPTION) {
                Logger.getInstance().addLog(String.format("Aborting reservation canceling request of %s for %s's room %d at %s",
                        getModel().getEmail(), email, room_number, hotel_name));
                return;
            }

            Reservation.removeReservation(email, startDate, hotel_name, room_number);
            getFrame().showReservationCancellationSuccessfulAlert(hotel_name, room_number, startDateString);
            searchButtonClicked();

        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
            getFrame().showGeneralInternalErrorAlert();

        } catch (ParseException e) {
            Logger.getInstance().addLog(e);
            getFrame().showGeneralInternalErrorAlert();

        } catch (ArrayIndexOutOfBoundsException e) {
            // row number 0
            getFrame().showNoReservationSelectedAlert();
        }
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
            Logger.getInstance().addLog(e);
            getFrame().showInvalidPasswordAlert();

        } catch (NoSuchAccountException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInternalErrorWhileUpdatingAlert();
        }
    }

    @Override
    AdminView getFrame() {
        return (AdminView) super.getFrame();
    }
}
