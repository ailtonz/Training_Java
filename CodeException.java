import java.util.HashMap;
import java.util.Map;

public class CodeException {

    public static Map<String, String> codeMap;

    static {
        codeMap = new HashMap<String, String>();
        codeMap.put("0", "Sem erros");
        codeMap.put("1", "Tamanho do header de segurança zerado ou incompatível com os possíveis");
        codeMap.put("2", "Versão inválida ou incompatível com o tamanho e/ou conexão");
        codeMap.put("3", "Algoritmo da chave do destinatário inválido ou divergente do certificado");
        codeMap.put("4", "Algoritmo simétrico inválido");
        codeMap.put("5", "Algoritmo da chave de assinatura (local) inválido ou divergente do certificado");
        codeMap.put("6", "Algoritmo de hash não corresponde aos indicados");
        codeMap.put("7", "Código da AC do Certificado do destinatário inválido");
        codeMap.put("8", "Número de série do certificado destino inválido ou divergente do Connect");
        codeMap.put("9", "Código da AC do Certificado local inválido");
        codeMap.put("10", "Número de série do certificado local inválido ou divergente do Connect");
        codeMap.put("11", "Assinatura da mensagem inválida ou com erro");
        codeMap.put("12", "Certificado não é o do emissor da mensagem");
        codeMap.put("13", "Erro na extração da chave simétrica");
        codeMap.put("14", "Erro gerado pelo algoritmo simétrico");
        codeMap.put("15", "Tamanho da mensagem não é múltiplo de 8 bytes");
        codeMap.put("16", "Certificado usado não está ativado");
        codeMap.put("17", "Certificado usado está revogado, vencido ou excluído pela instituição");
        codeMap.put("-1", "Erro na comunicação com o aplicativo");
        codeMap.put("101", "Erro ao extrair mensagem");
        codeMap.put("103", "Erro ao gerar assinatura");
        codeMap.put("105", "Erro ao executar o RSA");
        codeMap.put("106", "Tamanho do pacote inválido");
        codeMap.put("107", "Erro ao alocar memória");
        codeMap.put("108", "Erro na transmissão dos dados");
        codeMap.put("111", "Comando Inválido");
        codeMap.put("113", "Erro ao atualizar certificado proveniente de GEN0007 ou GEN0008");
        codeMap.put("114", "Erro abrindo arquivo");
        codeMap.put("115", "Erro iniciando API de criptografia");
        codeMap.put("116", "Erro executando método da API de criptografia");
        codeMap.put("117", "Erro executando método de resumo da API criptografia");
        codeMap.put("118", "Erro salvando dados em arquivo");
        codeMap.put("119", "Erro lendo arquivo");
        codeMap.put("120", "Erro escrevendo em arquivo");
        codeMap.put("121", "Erro de transmitindo/recebendo dados via rede");
        codeMap.put("122", "Mensagem maior que o permitido");
        codeMap.put("123", "Erro enviando certificado para os servidores parceiros");
        codeMap.put("124", "Parâmetro inválido");
        codeMap.put("125", "Lista de servidores vázia");
        codeMap.put("126", "Falha estabelecendo conexão com um dos servidores da lista");
        codeMap.put("127", "Falha total estabelecendo conexão com os servidores");
    }

    public static final String getMsgError(String code) {
        return codeMap.get(code);
    }
}