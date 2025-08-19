package cap1_analiseExtratosBancarios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class BankTransactionAnalyzerSimple {
	
	public static void main(final String ... args) throws IOException {
		
		// Representa um caminho no sistema de arquivos.
		final Path path = Paths.get("C:\\\\Users\\\\vynni\\\\3D Objects\\meuArquivo.txt");
		final java.util.List<String> lines = Files.readAllLines(path); // retorna uma lista de linhas.
		
		double total  = 0d;
		
		
		//separa  por ";", extrai o valor, analisa o valor.
		for(final String line : lines) {
			final String [] columns = line.split(";");
			final double amount = Double.parseDouble(columns[1]);
			total +=amount;
		}
		
		
		System.out.println("O total das trasações é: "+ total);
		
		System.out.println("\n\n-----------------------------\n");
		
		total  = 0d;
		final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
	
		
		for(final String line : lines) {
			final String [] columns = line.split(";");
			final LocalDate date = LocalDate.parse(columns[0],DATE_PATTERN);
			if(date.getMonth() == Month.FEBRUARY) {
				final double amount = Double.parseDouble(columns[1]);
				total+=amount;
			}
		}
		
		
		System.out.println("O total das trasações é no mês de Fevereiro é: "+ total);
		
		
	}
	
	
}
