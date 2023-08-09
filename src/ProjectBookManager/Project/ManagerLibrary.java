package ProjectBookManager.Project;

public class ManagerLibrary {
    public static void main(String[] args) {
        while (true) {
            runSystem();
        }
    }

    static void runSystem() {
        SystemManagement systemManagement = new SystemManagement();
        systemManagement.runningMenu();
    }
}
