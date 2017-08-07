/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import Model.TiposPagos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Penelope Lizardo
 */
@Stateless
public class TiposPagosFacade extends AbstractFacade<TiposPagos> {

    @PersistenceContext(unitName = "SistemaDeActivosFijosPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TiposPagosFacade() {
        super(TiposPagos.class);
    }
    
}
