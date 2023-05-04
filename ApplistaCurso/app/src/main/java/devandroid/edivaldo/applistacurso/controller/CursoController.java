package devandroid.edivaldo.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.edivaldo.applistacurso.model.Curso;

public class CursoController {

    private List listCursos;


    public List getListaDeCursos(){

        listCursos= new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("Php"));
        listCursos.add(new Curso("Python"));
        listCursos.add(new Curso("Html"));
        listCursos.add(new Curso("Css"));
        listCursos.add(new Curso("Ruby"));
        listCursos.add(new Curso("Kotlin"));

        return listCursos;

    }

    public ArrayList<String> dadosParaSpinner(){
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaDeCursos().size();i++){

            Curso objeto = (Curso) getListaDeCursos().get(i);
            dados.add(objeto.getNomeDoCursoDesejado());

        }
        return dados;

    }
}
