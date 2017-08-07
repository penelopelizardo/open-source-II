package controller;

import Model.Empleados;
import facade.EmpleadosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "empleadosController")
@ViewScoped
public class EmpleadosController extends AbstractController<Empleados> {

    @Inject
    private DepartamentosController departamentoController;
    @Inject
    private MobilePageController mobilePageController;

    public EmpleadosController() {
        // Inform the Abstract parent controller of the concrete Empleados Entity
        super(Empleados.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        departamentoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Departamentos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareDepartamento(ActionEvent event) {
        Empleados selected = this.getSelected();
        if (selected != null && departamentoController.getSelected() == null) {
            departamentoController.setSelected(selected.getDepartamento());
        }
    }

}
