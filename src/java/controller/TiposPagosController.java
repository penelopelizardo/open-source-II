package controller;

import Model.TiposPagos;
import facade.TiposPagosFacade;
import controller.util.MobilePageController;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "tiposPagosController")
@ViewScoped
public class TiposPagosController extends AbstractController<TiposPagos> {

    @Inject
    private MobilePageController mobilePageController;

    public TiposPagosController() {
        // Inform the Abstract parent controller of the concrete TiposPagos Entity
        super(TiposPagos.class);
    }

}
