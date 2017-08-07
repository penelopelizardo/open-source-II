package controller;

import Model.Departamentos;
import Model.ActivosFijos;
import Model.Empleados;
import java.util.Collection;
import facade.DepartamentosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "departamentosController")
@ViewScoped
public class DepartamentosController extends AbstractController<Departamentos> {

    @Inject
    private MobilePageController mobilePageController;

    // Flags to indicate if child collections are empty
    private boolean isActivosFijosCollectionEmpty;
    private boolean isEmpleadosCollectionEmpty;

    public DepartamentosController() {
        // Inform the Abstract parent controller of the concrete Departamentos Entity
        super(Departamentos.class);
    }

    /**
     * Set the "is[ChildCollection]Empty" property for OneToMany fields.
     */
    @Override
    protected void setChildrenEmptyFlags() {
        this.setIsActivosFijosCollectionEmpty();
        this.setIsEmpleadosCollectionEmpty();
    }

    public boolean getIsActivosFijosCollectionEmpty() {
        return this.isActivosFijosCollectionEmpty;
    }

    private void setIsActivosFijosCollectionEmpty() {
        Departamentos selected = this.getSelected();
        if (selected != null) {
            DepartamentosFacade ejbFacade = (DepartamentosFacade) this.getFacade();
            this.isActivosFijosCollectionEmpty = ejbFacade.isActivosFijosCollectionEmpty(selected);
        } else {
            this.isActivosFijosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of ActivosFijos entities
     * that are retrieved from Departamentos and returns the navigation outcome.
     *
     * @return navigation outcome for ActivosFijos page
     */
    public String navigateActivosFijosCollection() {
        Departamentos selected = this.getSelected();
        if (selected != null) {
            DepartamentosFacade ejbFacade = (DepartamentosFacade) this.getFacade();
            Collection<ActivosFijos> selectedActivosFijosCollection = ejbFacade.findActivosFijosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ActivosFijos_items", selectedActivosFijosCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/activosFijos/index";
    }

    public boolean getIsEmpleadosCollectionEmpty() {
        return this.isEmpleadosCollectionEmpty;
    }

    private void setIsEmpleadosCollectionEmpty() {
        Departamentos selected = this.getSelected();
        if (selected != null) {
            DepartamentosFacade ejbFacade = (DepartamentosFacade) this.getFacade();
            this.isEmpleadosCollectionEmpty = ejbFacade.isEmpleadosCollectionEmpty(selected);
        } else {
            this.isEmpleadosCollectionEmpty = true;
        }
    }

    /**
     * Sets the "items" attribute with a collection of Empleados entities that
     * are retrieved from Departamentos and returns the navigation outcome.
     *
     * @return navigation outcome for Empleados page
     */
    public String navigateEmpleadosCollection() {
        Departamentos selected = this.getSelected();
        if (selected != null) {
            DepartamentosFacade ejbFacade = (DepartamentosFacade) this.getFacade();
            Collection<Empleados> selectedEmpleadosCollection = ejbFacade.findEmpleadosCollection(selected);
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Empleados_items", selectedEmpleadosCollection);
        }
        return this.mobilePageController.getMobilePagesPrefix() + "/app/empleados/index";
    }

}
