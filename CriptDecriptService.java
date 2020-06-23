package br.com.votorantim.cash.base.cript.decript.service;
 
import br.com.evaltec.jcryptosfn.ResponseMessage;
import br.com.evaltec.jcryptosfn.SPBSecJava;
import br.com.evaltec.jcryptosfn.SPBSecStatus;
import br.com.votorantim.cash.base.cript.decript.exception.CriptDecriptException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
 
@Service
public class CriptDecriptService {
 
    private static final Logger logger = LoggerFactory.getLogger(CriptDecriptService.class);
    private int port = 10000; // @Value("${server.porta}")
    private String address = ""; // @Value("${server.address}")
 
 
    // Domínio da aplicação (Deve ser o mesmo configurado para o certificado)
    private String dominio = "SPB"; // @Value("${server.dominio}")
    private String ispbOrigem = ""; // @Value("${server.ispbOrigem}")
    private String ispbDestino = ""; // @Value("${server.ispbDestino}")
    private Boolean flag = false;
 
    public Boolean getFlag() { return flag; }
    public void setFlag(Boolean flag) { this.flag = flag; }
 
    public byte[] criptografar(String mensagem) {
        String strReturn = "";
 
        try {
            // Obtem a mensagem em byte codificada UTF-16BE
            byte[] msg = new byte[0];
            try {
                msg = mensagem.getBytes("UTF-16BE");
            } catch (UnsupportedEncodingException e) {
                logger.info(e.getMessage());
            }
 
            // Cria a classe de acesso ao servidor
            logger.info("Criptografia | " + "Cria a classe de acesso ao servidor");
            SPBSecJava cryptosfn = new SPBSecJava();
 
            // Adiciona um servidor
            logger.info("Criptografia | " + "Adiciona um servidor");
            InetAddress addr = addServidor();
            cryptosfn.addServer(addr, port);
 
            int i = 1;
            do {
                logger.info("Criptografia | " + "Inicializa a conexão com os servidores");
                int n = cryptosfn.initialize();
 
                // Verifica se todos as conexões foram estabelevida
                logger.info("Criptografia | " + "Verifica se todos as conexões foram estabelevida - TESTANDO: [  " + i + " - 3 ] ");
                logger.info("Valor de n " + n);
 
                if (n != 1) {
                    logger.info("Parando loop da conexao");
                    break;
                }
                i++;
            }  while ( i <= 3 );
 
            // Mensagem normal
            logger.info("Criptografia | " + "Mensagem normal");
            byte codMsg = SPBSecJava.MSG_NORMAL;
 
            // Utilizado apenas em mensagem GEN0004
            byte errGen0004 = 0;
 
            // Cifra uma mensagem
            logger.info("Criptografia | " + "Cifra uma mensagem");
            ResponseMessage responseMessage1 = cryptosfn.encryptMsg(dominio, ispbOrigem, ispbDestino, codMsg, msg, errGen0004);
 
            // Verifica o status
            logger.info("Criptografia | " + "Verifica o status");
 
            if (responseMessage1.getStatus() != SPBSecStatus.NO_ERROR && getFlag() == false) {
                throw new CriptDecriptException("Erro ao criptografar a mensagem " + String.valueOf(responseMessage1.getStatus()));
            } else {
                // logger.info("Criptografia | " + "Retorno da mensagem criptografada");
                byte responseMsg[] = responseMessage1.getMsg();

                // O byte array msg deve ser enviado sem alterações para o MQ, sendo enviado como um mensagem binária. - Não altere este byte array ou o log será invalidado.
                logger.info("Recuperando log mensagem criptografada");
                byte logMsg[] = responseMessage1.getLogMsg();

                logger.info("Recuperando mensagem criptografada");
                logger.info(responseMsg);
			   return responseMsg;
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return responseMsg;
    }
 
 
    public String descriptografar(byte[] mensageCriptografada) {
        String strReturn = "";
        try {
            // Cria a classe de acesso ao servidor
            logger.info("Decriptografia | " + "Cria a classe de acesso ao servidor");
            SPBSecJava cryptosfn = new SPBSecJava();
 
            // Adiciona um servidor
            logger.info("Decriptografia | " + "Adiciona um servidor");
            InetAddress addr = addServidor();
            cryptosfn.addServer(addr, port);
 
            int i = 1;
            do {
                // Inicializa
                logger.info("Decriptografia | " + "Inicializa a conexão com os servidores");
                int n = cryptosfn.initialize();
 
                // Verifica se todos as conexões foram estabelevida
                logger.info("Decriptografia | " + "Verifica se todos as conexões foram estabelevida - TESTANDO: [  " + i + " - 3 ] ");
                logger.info("Valor de n " + n);
 
                if (n != 1) {
                    logger.info("Parando loop da conexao");
                    break;
                }
                i++;
            }  while ( i <= 3 );
 
            // Decifrando a mensagem
            logger.info("Decriptografia | " + "Decifrando a mensagem");
            ResponseMessage responseMessage2 = cryptosfn.decryptMsg(dominio, ispbDestino, ispbOrigem, mensageCriptografada);
 
            // Verifica o status
            logger.info("Decriptografia | " + "Verifica o status");
            if(responseMessage2.getStatus() != SPBSecStatus.NO_ERROR && getFlag() == false) {
                throw new CriptDecriptException("Erro ao criptografar a mensagem " + responseMessage2.getStatus() + " " + SPBSecStatus.NO_ERROR);
            } else {
                // Processa a mensagem
                byte msg[] = responseMessage2.getMsg();
                logger.info("Recuperando mensagem descriptografada");
 
                // Converta a mensagem para String
                strReturn = new String(msg);
                logger.info(strReturn);
                logger.info("Recuperando log mensagem descriptografada");
 
                // Lembre de salvar a mensagem de log - Não altere este byte array ou o log será invalidado.
                byte logMsg[] = responseMessage2.getLogMsg();
                logger.info(new String(logMsg));
            }
        } catch (Exception e) {
            logger.info(e.getMessage());
        }
        return strReturn;
    }
 
    private InetAddress addServidor() {
        try {
            InetAddress ia = InetAddress.getByName(address);
            return ia;
        } catch (Exception e) {
            logger.info("Erro ao adicionar o servidor: " + e.getMessage());
        }
        return null;
    }
}