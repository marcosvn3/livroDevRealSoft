package cap1_analiseExtratosBancarios.SRP;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
	private static String resource = "C:\\Users\\vynni\\3D Objects\\";
	private static BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
	
	
	
	public static void main(String[] args) throws IOException {
		final Path path = Paths.get(resource + "meuArquivo.txt" );
		
		List<String> linhas = Files.readAllLines(path);
		
		
		List<BankTransaction> bankTransactions = bankStatementParser.parseLineFromCSV(linhas);
		
		BankStatementProcessor bankStatementProcessor = new BankStatementProcessor(bankTransactions);
		
		collectSumary(bankStatementProcessor);
		
	}

	
	public static void collectSumary(BankStatementProcessor bankStatementProcessor) {
		System.out.println("O total de todas as transações são: "+ bankStatementProcessor.calculateTotalAmount());
		
		System.out.println("O total de todas as transações de Fevereiro: "+ bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
		
		System.out.println("O total de salario recebido : "+ bankStatementProcessor.calculateTotalForCategory("salario"));
		
	}
	
}
