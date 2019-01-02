package io.pivotal.cloudnativespringui;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import io.pivotal.cloudnativespring.domain.City;
import io.pivotal.cloudnativespringui.CloudNativeSpringUiApplication.CityClient;
import org.springframework.beans.factory.annotation.Autowired;

@Theme(Lumo.class)
@Route("")
public class AppUI extends VerticalLayout {

  private final CityClient cityClient;

  private final Grid<City> grid;

  @Autowired
  public AppUI(CityClient cityClient) {
    this.cityClient = cityClient;

    grid = new Grid<>(City.class);
    add(grid);
    grid.setWidth("100");
    grid.setHeight("100");
    grid.setItems(cityClient.getCities().getContent());
  }
}