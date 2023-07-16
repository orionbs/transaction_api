package fr.orionbs.transaction_manager_server.adapter.input.shell.category;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class CategoryShellAdapter {

    @ShellMethod(key = "categories")
    public List<String> getCategories() {
        return List.of("Transport,Restaurant,Food");
    }

}
