package examples.stateless;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import examples.model.Department;

@Stateless
public class DepartmentService {
    @PersistenceContext(unitName="EmployeeService")
    protected EntityManager em;

    public Department createDepartment(String name) {
        Department dept = new Department();
        dept.setName(name);
        em.persist(dept);
        
        return dept;
    }

    public Collection<Department> findAllDepartments() {
        TypedQuery query = em.createQuery("SELECT d FROM Department d", Department.class);
        return query.getResultList();
    }
}
