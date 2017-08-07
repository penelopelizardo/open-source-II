/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Model.Ubicaciones;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.Ubicaciones_;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import Model.ActivosFijos;
import java.util.Collection;

/**
 *
 * @author Penelope Lizardo
 */
@Stateless
public class UbicacionesFacade extends AbstractFacade<Ubicaciones> {

    @PersistenceContext(unitName = "SistemaDeActivosFijosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UbicacionesFacade() {
        super(Ubicaciones.class);
    }

    public boolean isActivosFijosCollectionEmpty(Ubicaciones entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<Ubicaciones> ubicaciones = cq.from(Ubicaciones.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(ubicaciones, entity), cb.isNotEmpty(ubicaciones.get(Ubicaciones_.activosFijosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<ActivosFijos> findActivosFijosCollection(Ubicaciones entity) {
        Ubicaciones mergedEntity = this.getMergedEntity(entity);
        Collection<ActivosFijos> activosFijosCollection = mergedEntity.getActivosFijosCollection();
        activosFijosCollection.size();
        return activosFijosCollection;
    }
    
}
