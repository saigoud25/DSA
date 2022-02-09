690. Employee Importance
https://leetcode.com/problems/employee-importance/

/*
->Create a HashMap and traverse the employees list and store the id as key and Employee as value
HashMap<Id, Employee>
->DFS using given id, if that Id has no subordinates return emp.importance
*/
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> hm = new HashMap();
        for(Employee e : employees)
        {
            hm.put(e.id, e);
        }
        return dfs(id, hm);
    }
    public int dfs(int id, Map<Integer, Employee> hm)
    {
        Employee emp = hm.get(id);
        if(emp.subordinates.size()==0)
        {
            return emp.importance;
        }
        int sum = emp.importance;
        for(Integer i : emp.subordinates)
        {
            sum += dfs(i, hm);
        }
        return sum; 
    }
}
