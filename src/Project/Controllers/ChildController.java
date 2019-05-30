package Project.Controllers;

abstract class ChildController extends Controller {
    private ParentController parent;

    void sendSignalToParent() {
        parent.receiveSignalFromChild();
    }

    void setParent(ParentController parent) {
        this.parent = parent;
    }

    private ParentController getParent() {
        return parent;
    }
}
