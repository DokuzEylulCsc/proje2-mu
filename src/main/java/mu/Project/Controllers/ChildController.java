package mu.Project.Controllers;

abstract class ChildController extends Controller {
    ParentController parent;

    void sendSignalToParent() {
        parent.receiveSignalFromChild();
    }

    void setParent(ParentController parent) {
        this.parent = parent;
    }

    ParentController getParent() {
        return parent;
    }
}
