package com.techelevator;


import javax.print.attribute.standard.MediaSize;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private List<Department> departments = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private Map<String, Project> projects = new HashMap<>();
    /**
     * The main entry point in the application
     * @param args
     */
    public static void main(String[] args) {
        Application app = new Application();
        app.run();
    }

    private void run() {
        // create some departments
        createDepartments();

        // print each department by name
        printDepartments();

        // create employees
        createEmployees();

        // give Angie a 10% raise, she is doing a great job!

        // print all employees
        printEmployees();

        // create the TEams project
        createTeamsProject();
        // create the Marketing Landing Page Project
        createLandingPageProject();

        // print each project name and the total number of employees on the project
        printProjectsReport();
    }

    /**
     * Create departments and add them to the collection of departments
     */
        private void createDepartments() {
        departments.add(new Department(1, "Marketing"));
        departments.add(new Department(2, "Sales"));
        departments.add(new Department(3, "Engineering"));
        }
        /**
         * Print out each department in the collection.
         */
        private void printDepartments() {
            System.out.println("------------- DEPARTMENTS ------------------------------");
            for(Department dpt: departments){
                System.out.println(dpt.getName());
            }
        }

    /**
     * Create employees and add them to the collection of employees
     */
    private void createEmployees() {
        employees.add(new Employee(1, "Dean", "Johnson", "djohnson@teams.com", departments.get(2), "08/21/2020" ));
        employees.add(new Employee(2, "Angie", "Smith", "asmith@teams.com", departments.get(2), "08/21/2020"));
        employees.add(new Employee(3, "Margaret", "Thompson", "mthompson@teams.com", departments.get(0), "08/21/2020"));
    }

    /**
     * Print out each employee in the collection.
     */
    private void printEmployees() {
        employees.get(1).raiseSalary(.10); //prompt user to input percent as value between 0 & 1
        System.out.println("\n------------- EMPLOYEES ------------------------------");

        for(Employee emp: employees){
            System.out.println(emp.getFullName()+" ("+emp.getSalary()+") "+emp.getDepartment().getName());

        }
    }

    /**
     * Create the 'TEams' project.
     */
    private void createTeamsProject() {
        Project teamsProject = new Project("TEam", "Project Management Software", "10/10/2020", "11/10/2020");
        List<Employee> employeeEngineer = new ArrayList<Employee>();
        for (int i = 0; i<employees.size(); i++) {
            if(employees.get(i).getDepartment().getName().equals("Engineering")){
                employeeEngineer.add(employees.get(i));
            }
        }
        teamsProject.setTeamMembers(employeeEngineer);
        projects.put("TEam", teamsProject);
    }
    /**
     * Create the 'Marketing Landing Page' project.
     */
    private void createLandingPageProject() {
        Project landingPagesProject = new Project("Marketing Landing Page", "Project Management Software", "10/10/2020", "11/10/2020");
        List<Employee> employeeMarketing = new ArrayList<Employee>();
        for (int i = 0; i<employees.size(); i++) {
            if(employees.get(i).getDepartment().getName().equals("Marketing")){
                employeeMarketing.add(employees.get(i));
            }
        }
        landingPagesProject.setTeamMembers(employeeMarketing);
        projects.put("Marketing Landing Page", landingPagesProject);
    }

    /**
     * Print out each project in the collection.
     */
    private void printProjectsReport() {
        System.out.println("\n------------- PROJECTS ------------------------------");
        for(Map.Entry<String, Project> project: projects.entrySet()){
            System.out.println(project.getKey()+" : "+project.getValue().getTeamMembers().size());
        }
    }

}
