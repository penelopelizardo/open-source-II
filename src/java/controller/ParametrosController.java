package controller;

import Model.Parametros;
import facade.ParametrosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "parametrosController")
@ViewScoped
public class ParametrosController extends AbstractController<Parametros> {

    @Inject
    private MobilePageController mobilePageController;

    public ParametrosController() {
        // Inform the Abstract parent controller of the concrete Parametros Entity
        super(Parametros.class);
    }

}
