package controller;

import Model.Ubicaciones;
import Model.ActivosFijos;
import java.util.Collection;
import facade.UbicacionesFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "ubicacionesController")
@ViewScoped
public class UbicacionesController extends AbstractController<Ubicaciones> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isActivosFijosCollectionEmpty;

    public UbicacionesController() {
        // Inform the Abstract parent controller of the concrete Ubicaciones Entity
        super(Ubicaciones.class);
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
        Ubicaciones selected = this.getSelected();
        if (selected != null) {
            UbicacionesFacade ejbFacade = (UbicacionesFacade) this.getFacade();
            this.isActivosFijosCollectionEmpty = ejbFacade.isActivosFijosCollectionEmpty(selected);
        } else {
            this.isActivosFijosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of ActivosFijos entities
     * that are retrieved from Ubicaciones and returns the navigation outcome.
     *
     * @return navigation outcome for ActivosFijos page
     */
    public String navigateActivosFijosCollection() {
        Ubicaciones selected = this.getSelected();
        if (selected != null) {
            UbicacionesFacade ejbFacade = (UbicacionesFacade) this.getFacade();
            Collection<ActivosFijos> selectedActivosFijosCollection = ejbFacade.findActivosFijosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ActivosFijos_items", selectedActivosFijosCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/activosFijos/index";
    }

}
