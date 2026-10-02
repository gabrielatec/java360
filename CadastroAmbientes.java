package br.com.romulo.curso.arquivos;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;


public class CadastroAmbientes {

    private static final String ARQUIVO_DB = "ambientes.txt";
    private static final Map<String, String> mapaAmbientes = new HashMap<>();
    private static final DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    void main() {
        carregarDados();
        executarMenu();
    }

    private static void executarMenu() {
        int opcao = 0;
        do {
            String menu = """
                    --- SISTEMA DE AMBIENTES ---
                    1. Cadastrar Ambiente
                    2. Listar Ambientes
                    3. Pesquisar Ambiente
                    4. Alterar Ambiente
                    5. Excluir Ambiente
                    6. Sair
                    
                    Escolha uma opção:""";

            String entrada = JOptionPane.showInputDialog(null, menu, "Menu Principal", JOptionPane.QUESTION_MESSAGE);
            
            if (entrada == null) {
                opcao = 6; // Se o usuário fechar ou cancelar, define como sair
            } else {
                try {
                    opcao = Integer.parseInt(entrada.trim());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Por favor, digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    continue;
                }
            }

            switch (opcao) {
                case 1 -> cadastrar();
                case 2 -> listar();
                case 3 -> pesquisar();
                case 4 -> alterar();
                case 5 -> excluir();
                case 6 -> JOptionPane.showMessageDialog(null, "Saindo do sistema. Até logo!", "Encerramento", JOptionPane.INFORMATION_MESSAGE);
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
            }
        } while (opcao != 6);
    }

    private static void cadastrar() {
        String codigo = JOptionPane.showInputDialog("Digite o código do ambiente (Ex: F07):");
        if (codigo == null || codigo.isBlank()) return;
        codigo = codigo.trim().toUpperCase();

        if (mapaAmbientes.containsKey(codigo)) {
            JOptionPane.showMessageDialog(null, "Código já existente! Use a opção de alterar se necessário.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String descricao = JOptionPane.showInputDialog("Digite a descrição do ambiente:");
        if (descricao == null || descricao.isBlank()) return;

        mapaAmbientes.put(codigo, descricao.trim());
        salvarDados();
        JOptionPane.showMessageDialog(null, "Ambiente cadastrado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void listar() {
        if (mapaAmbientes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum ambiente cadastrado.", "Lista Vazia", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder("--- AMBIENTES CADASTRADOS ---\n");
        mapaAmbientes.forEach((codigo, descricao) -> sb.append(String.format("[%s] - %s\n", codigo, descricao)));
        
        JOptionPane.showMessageDialog(null, sb.toString(), "Listagem", JOptionPane.PLAIN_MESSAGE);
    }

    private static void pesquisar() {
        String codigo = JOptionPane.showInputDialog("Digite o código para pesquisar:");
        if (codigo == null || codigo.isBlank()) return;
        codigo = codigo.trim().toUpperCase();

        if (mapaAmbientes.containsKey(codigo)) {
            String desc = mapaAmbientes.get(codigo);
            JOptionPane.showMessageDialog(null, String.format("Ambiente Encontrado:\nCódigo: %s\nDescrição: %s", codigo, desc), "Resultado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ambiente não encontrado.", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }

    private static void alterar() {
        String codigo = JOptionPane.showInputDialog("Digite o código do ambiente que deseja alterar:");
        if (codigo == null || codigo.isBlank()) return;
        codigo = codigo.trim().toUpperCase();

        if (!mapaAmbientes.containsKey(codigo)) {
            JOptionPane.showMessageDialog(null, "Ambiente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String novaDescricao = JOptionPane.showInputDialog("Atual descrição: " + mapaAmbientes.get(codigo) + "\nDigite a nova descrição:");
        if (novaDescricao == null || novaDescricao.isBlank()) return;

        mapaAmbientes.put(codigo, novaDescricao.trim());
        salvarDados();
        JOptionPane.showMessageDialog(null, "Ambiente atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
    }

    private static void excluir() {
        String codigo = JOptionPane.showInputDialog("Digite o código do ambiente que deseja excluir:");
        if (codigo == null || codigo.isBlank()) return;
        codigo = codigo.trim().toUpperCase();

        if (mapaAmbientes.containsKey(codigo)) {
            mapaAmbientes.remove(codigo);
            salvarDados();
            JOptionPane.showMessageDialog(null, "Ambiente excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Ambiente não encontrado.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void salvarDados() {
        FileWriter escritor = null;
        try {
            escritor = new FileWriter(ARQUIVO_DB);
            String dataAtual = LocalDateTime.now().format(formatadorData);
            escritor.write("# Banco de Dados - Atualizado em: " + dataAtual + "\n");
            
            for (Map.Entry<String, String> registro : mapaAmbientes.entrySet()) {
                escritor.write(registro.getKey() + ";" + registro.getValue() + "\n");
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Erro crítico ao salvar no arquivo: " + e.getMessage(), "Erro de Arquivo", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (escritor != null) {
                try {
                    escritor.close();
                } catch (IOException e) {
                    System.err.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }

    private static void carregarDados() {
          try (BufferedReader leitor = new BufferedReader(new FileReader(ARQUIVO_DB))) {
            String linha;
            while ((linha = leitor.readLine()) != null) {
                if (linha.startsWith("#") || linha.isBlank()) continue;
                String[] partes = linha.split(";", 2);
                if (partes.length == 2) {
                    mapaAmbientes.put(partes[0].trim(), partes[1].trim());
                }
            }
        } catch (IOException e) {
            // Se o arquivo não existir, popula a memória com a carga inicial padrão solicitada
            mapaAmbientes.put("F07", "Laboratório de Programação Java");
            mapaAmbientes.put("B03", "Sala de Aula Padrão");
            mapaAmbientes.put("G09", "Oficina de Lanternagem e Pintura");
            salvarDados();
        }
    }
}
        
     

