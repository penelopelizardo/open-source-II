/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Model.TiposActivos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import Model.TiposActivos_;
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
public class TiposActivosFacade extends AbstractFacade<TiposActivos> {

    @PersistenceContext(unitName = "SistemaDeActivosFijosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposActivosFacade() {
        super(TiposActivos.class);
    }

    public boolean isActivosFijosCollectionEmpty(TiposActivos entity) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> cq = cb.createQuery(Long.class);
        Root<TiposActivos> tiposActivos = cq.from(TiposActivos.class);
        cq.select(cb.literal(1L)).distinct(true).where(cb.equal(tiposActivos, entity), cb.isNotEmpty(tiposActivos.get(TiposActivos_.activosFijosCollection)));
        return em.createQuery(cq).getResultList().isEmpty();
    }

    public Collection<ActivosFijos> findActivosFijosCollection(TiposActivos entity) {
        TiposActivos mergedEntity = this.getMergedEntity(entity);
        Collection<ActivosFijos> activosFijosCollection = mergedEntity.getActivosFijosCollection();
        activosFijosCollection.size();
        return activosFijosCollection;
    }
    
}
