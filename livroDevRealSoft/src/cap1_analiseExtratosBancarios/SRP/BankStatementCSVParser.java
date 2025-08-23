package cap1_analiseExtratosBancarios.SRP;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class BankStatementCSVParser {
	private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	
	private BankTransaction parseFromCSV(final String line) {
		
		final String [] colunas = line.split(";");
		
		
		final LocalDate data = LocalDate.parse(colunas[0],DATE_PATTERN);
		final double amount =  Double.parseDouble(colunas[1]);
		final String descricao = colunas[2];
		
		return new BankTransaction(data,amount,descricao); 
	}
	
	
	
	public List<BankTransaction> parseLineFromCSV(List<String> linhas){
		
		final List<BankTransaction> bankTransactions = new ArrayList();
		
		for(final String linha : linhas) {
			bankTransactions.add(parseFromCSV(linha));
		}
		
		return bankTransactions;
	
	}
	
	
	
	
	
	
}
