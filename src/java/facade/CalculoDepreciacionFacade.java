/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Model.CalculoDepreciacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.CalculoDepreciacion_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.ActivosFijos;

/**
 *
 * @author Penelope Lizardo
 */
@Stateless
public class CalculoDepreciacionFacade extends AbstractFacade<CalculoDepreciacion> {

    @PersistenceContext(unitName = "SistemaDeActivosFijosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalculoDepreciacionFacade() {
        super(CalculoDepreciacion.class);
    }

    public boolean isActivofijoEmpty(CalculoDepreciacion entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<CalculoDepreciacion> calculoDepreciacion = cq.from(CalculoDepreciacion.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(calculoDepreciacion, entity), cb.isNotNull(calculoDepreciacion.get(CalculoDepreciacion_.activofijo)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public ActivosFijos findActivofijo(CalculoDepreciacion entity) {
        return this.getMergedEntity(entity).getActivofijo();
    }
    
}
