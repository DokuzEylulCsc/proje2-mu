package mu.Project.Controllers;

abstract class ChildController extends Controller {
    MainController parent;

    void setParent(MainController parent) {
        this.parent = parent;
    }

    MainController getParent() {
        return parent;
    }
}
