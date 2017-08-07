package controller;

import Model.TiposActivos;
import Model.ActivosFijos;
import java.util.Collection;
import facade.TiposActivosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "tiposActivosController")
@ViewScoped
public class TiposActivosController extends AbstractController<TiposActivos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isActivosFijosCollectionEmpty;

    public TiposActivosController() {
        // Inform the Abstract parent controller of the concrete TiposActivos Entity
        super(TiposActivos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsActivosFijosCollectionEmpty();
    }

    public boolean getIsActivosFijosCollectionEmpty() {
        return this.isActivosFijosCollectionEmpty;
    }

    private void setIsActivosFijosCollectionEmpty() {
        TiposActivos selected = this.getSelected();
        if (selected != null) {
            TiposActivosFacade ejbFacade = (TiposActivosFacade) this.getFacade();
            this.isActivosFijosCollectionEmpty = ejbFacade.isActivosFijosCollectionEmpty(selected);
        } else {
            this.isActivosFijosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of ActivosFijos entities
     * that are retrieved from TiposActivos and returns the navigation outcome.
     *
     * @return navigation outcome for ActivosFijos page
     */
    public String navigateActivosFijosCollection() {
        TiposActivos selected = this.getSelected();
        if (selected != null) {
            TiposActivosFacade ejbFacade = (TiposActivosFacade) this.getFacade();
            Collection<ActivosFijos> selectedActivosFijosCollection = ejbFacade.findActivosFijosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ActivosFijos_items", selectedActivosFijosCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/activosFijos/index";
    }

}
