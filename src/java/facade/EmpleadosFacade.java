/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Model.Empleados;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Empleados_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.Departamentos;

/**
 *
 * @author Penelope Lizardo
 */
@Stateless
public class EmpleadosFacade extends AbstractFacade<Empleados> {

    @PersistenceContext(unitName = "SistemaDeActivosFijosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpleadosFacade() {
        super(Empleados.class);
    }

    public boolean isDepartamentoEmpty(Empleados entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Empleados> empleados = cq.from(Empleados.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(empleados, entity), cb.isNotNull(empleados.get(Empleados_.departamento)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Departamentos findDepartamento(Empleados entity) {
        return this.getMergedEntity(entity).getDepartamento();
    }
    
}
