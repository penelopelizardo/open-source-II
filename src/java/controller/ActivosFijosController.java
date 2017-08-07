package controller;

import Model.ActivosFijos;
import Model.CalculoDepreciacion;
import java.util.Collection;
import facade.ActivosFijosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "activosFijosController")
@ViewScoped
public class ActivosFijosController extends AbstractController<ActivosFijos> {

    @Inject
    private DepartamentosController departamentoController;
    @Inject
    private UbicacionesController ubicacionController;
    @Inject
    private TiposActivosController tipoactivoController;
    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isCalculoDepreciacionCollectionEmpty;

    public ActivosFijosController() {
        // Inform the Abstract parent controller of the concrete ActivosFijos Entity
        super(ActivosFijos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        departamentoController.setSelected(null);
        ubicacionController.setSelected(null);
        tipoactivoController.setSelected(null);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsCalculoDepreciacionCollectionEmpty();
    }

    /**
     * Sets the "selected" attribute of the Departamentos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDepartamento(ActionEvent event) {
        ActivosFijos selected = this.getSelected();
        if (selected != null && departamentoController.getSelected() == null) {
            departamentoController.setSelected(selected.getDepartamento());
        }
    }

    /**
     * Sets the "selected" attribute of the Ubicaciones controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareUbicacion(ActionEvent event) {
        ActivosFijos selected = this.getSelected();
        if (selected != null && ubicacionController.getSelected() == null) {
            ubicacionController.setSelected(selected.getUbicacion());
        }
    }

    /**
     * Sets the "selected" attribute of the TiposActivos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareTipoactivo(ActionEvent event) {
        ActivosFijos selected = this.getSelected();
        if (selected != null && tipoactivoController.getSelected() == null) {
            tipoactivoController.setSelected(selected.getTipoactivo());
        }
    }

    public boolean getIsCalculoDepreciacionCollectionEmpty() {
        return this.isCalculoDepreciacionCollectionEmpty;
    }

    private void setIsCalculoDepreciacionCollectionEmpty() {
        ActivosFijos selected = this.getSelected();
        if (selected != null) {
            ActivosFijosFacade ejbFacade = (ActivosFijosFacade) this.getFacade();
            this.isCalculoDepreciacionCollectionEmpty = ejbFacade.isCalculoDepreciacionCollectionEmpty(selected);
        } else {
            this.isCalculoDepreciacionCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of CalculoDepreciacion
     * entities that are retrieved from ActivosFijos and returns the navigation
     * outcome.
     *
     * @return navigation outcome for CalculoDepreciacion page
     */
    public String navigateCalculoDepreciacionCollection() {
        ActivosFijos selected = this.getSelected();
        if (selected != null) {
            ActivosFijosFacade ejbFacade = (ActivosFijosFacade) this.getFacade();
            Collection<CalculoDepreciacion> selectedCalculoDepreciacionCollection = ejbFacade.findCalculoDepreciacionCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("CalculoDepreciacion_items", selectedCalculoDepreciacionCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/calculoDepreciacion/index";
    }

}
