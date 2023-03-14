package service;

import entity.ObraLiteraria;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import javax.swing.JOptionPane;
import repository.ObraLiterariaRepository;

public class ObraLiterariaService {

    ObraLiterariaRepository obraLiterariaRepository = new ObraLiterariaRepository();

    public ObraLiteraria salvarObraLiteraria(ObraLiteraria obraLiteraria) {
        if ((validaGenero(obraLiteraria.getGenero()))
                && (validaEditora(obraLiteraria.getEditora()))
                && (validaAnoPublicacao(obraLiteraria.getAnoPublicacao()))
                && (validaIdioma(obraLiteraria.getIdioma()))
                && (validaNumeroPaginas(obraLiteraria.getNumeroPaginas()))) {
            obraLiterariaRepository.salvarObraLiteraria(obraLiteraria);
        } else {
            JOptionPane.showMessageDialog(null, "ERRRRO algum campo está com valor inválido");
        }
        return null;
    }

    public ObraLiteraria buscarObraLiteraria(int id) {
        return obraLiterariaRepository.buscarObraLiteraria(id);
    }

    public ObraLiteraria editarObraLiteraria(ObraLiteraria obraLiteraria) {
        return obraLiterariaRepository.editarObraLiteraria(obraLiteraria);
    }

    public ObraLiteraria excluirObraLiteraria(ObraLiteraria obraLiteraria) {
        return obraLiterariaRepository.excluirObraLiteraria(obraLiteraria);
    }

    private boolean validaGenero(String genero) {
        List<String> generos = Arrays.asList("romance", "novela", "conto", "crônica", "poema", "canção", "drama");
        return generos.contains(genero);
    }

    private boolean validaEditora(String editora) {
        List<String> editoras = Arrays.asList("saraiva", "globo", "suma");
        return editoras.contains(editora);
    }

    private boolean validaAnoPublicacao(int anoPublicacao) {
        return LocalDate.now().getYear() >= anoPublicacao;
    }

    private boolean validaNumeroPaginas(int numeroPaginas) {
        return numeroPaginas >= 0;
    }

    private boolean validaIdioma(String idioma) {
        List<String> idiomas = Arrays.asList("alemao", "russo", "guarani", "ingles", "portugues");
        return idiomas.contains(idioma);
    }

}
