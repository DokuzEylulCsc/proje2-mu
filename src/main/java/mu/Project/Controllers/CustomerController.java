package mu.Project.Controllers;

import mu.Project.Connector;
import mu.Project.Logger;
import mu.Project.Models.*;
import mu.Project.Views.CustomerView;

import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

// TODO: Make reservationTable select only one record at a time.
public class CustomerController extends AccountController {
    private final static DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

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
        getFrame().setVisible(true);
    }

    public void closeProgram() {
        Logger.getInstance().addLog("Trying to close JDBC...");

        try {
            Connector.getInstance().getConnection().close();
            Logger.getInstance().addLog("Closed JDBC successfully.");
        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
        }
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
            Logger.getInstance().addLog(e);
            getFrame().showInvalidDateFormatAlert();

        } catch (InvalidDateIntervalException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInvalidDateIntervalAlert();

        } catch (NullPointerException e) {
            Logger.getInstance().addLog("Search button at CustomerView.reserveTab clicked with an null value.");
            getFrame().showEmptyRequiredFieldAlert();
        }

    }

    public void reserveButtonClicked() {
        int row = getFrame().getReservationTable().getSelectedRow();
        System.out.println(String.valueOf(row) + ", " + getFrame().getReservationTable().getRowHeight());

        String hotel_name = (String) getFrame().getReservationTable().getValueAt(row, 0);
        Integer room_number = (Integer) getFrame().getReservationTable().getValueAt(row, 3);
        Integer person_count = (Integer) getFrame().getPersonCountSpinner().getValue();
        String startDateString = (String) getFrame().getStartDateField().getValue();
        String endDateString = (String) getFrame().getEndDateField().getValue();

        try {
            Date startDate = dateFormat.parse(startDateString);
            Date endDate = dateFormat.parse(endDateString);
            Reservation.reserveRoom(getModel(), hotel_name, room_number, person_count, startDate, endDate);
            getFrame().showReservationSuccessfulAlert(hotel_name, room_number, startDateString, endDateString);
            searchButtonClicked();

        } catch (ParseException e) {
            Logger.getInstance().addLog(e);
            getFrame().showInvalidDateFormatAlert();
        } catch (SQLException e) {
            Logger.getInstance().addLog(e);
            getFrame().showGeneralInternalErrorAlert();
        }
    }

    public void cancelReservationButtonClicked() {
        int row = getFrame().getReservedTable().getSelectedRow();

    }


    public void refreshReservedTableButtonClicked() {
        String email = getModel().getEmail();
        DefaultTableModel tableModel = Reservation.getReservedRoomsAsTableModel(email);
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
            Logger.getInstance().addLog(e);
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
