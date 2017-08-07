package controller;

import Model.CalculoDepreciacion;
import facade.CalculoDepreciacionFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "calculoDepreciacionController")
@ViewScoped
public class CalculoDepreciacionController extends AbstractController<CalculoDepreciacion> {

    @Inject
    private ActivosFijosController activofijoController;
    @Inject
    private MobilePageController mobilePageController;

    public CalculoDepreciacionController() {
        // Inform the Abstract parent controller of the concrete CalculoDepreciacion Entity
        super(CalculoDepreciacion.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        activofijoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the ActivosFijos controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareActivofijo(ActionEvent event) {
        CalculoDepreciacion selected = this.getSelected();
        if (selected != null && activofijoController.getSelected() == null) {
            activofijoController.setSelected(selected.getActivofijo());
        }
    }

}
