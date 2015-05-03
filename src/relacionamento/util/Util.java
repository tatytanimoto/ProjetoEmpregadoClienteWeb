/**
 * 
 */
package relacionamento.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Classe utilitária para a validação de entrada de dados.
 * 
 * @author Baracho
 * 
 * @since 03/04/2014
 * 
 * @version 3.0
 * 
 */
public class Util {

	// Variáveis de instância

	private final static String ERROR_ACTION = "\n Valor Inválido!"
			+ " Digite Novamente.";

	// Função construtora

	public Util() {

	}

	// Operações da Classe

	@SuppressWarnings("resource")
	public static Character validarCharacter(String msg) {

		// Declaração de variáveis

		Character valor = null;

		String str = null;

		boolean flag = false;

		Scanner scanner = null;

		// Processamento dos dados

		do {

			flag = false;

			scanner = new Scanner(System.in);

			System.out.print("\n " + msg);

			str = scanner.nextLine();

			if (!str.equals("")) {

				valor = new Character(str.charAt(0));

			} else {

				System.out.println(ERROR_ACTION);

				flag = true;

			}

		} while (flag);

		// Saída do método

		return valor;
	}

	@SuppressWarnings("resource")
	public static Character validarCharacterNull(String msg) {

		// Declaração de variáveis

		Character valor = null;

		String str = null;

		Scanner scanner = null;

		// Processamento dos dados

		scanner = new Scanner(System.in);

		System.out.print("\n " + msg);

		str = scanner.nextLine();

		if (!str.equals("")) {

			valor = new Character(str.charAt(0));

		} else {

			valor = null;
		}

		// Saída da informação

		return valor;

	}

	@SuppressWarnings("resource")
	public static Integer validarInt(String msg) {

		// Declaração de variáveis

		Integer valor = null;

		boolean flag = false;

		Scanner scanner = null;

		scanner = new Scanner(System.in);

		// Processamento dos dados

		do {

			flag = false;

			scanner = new Scanner(System.in);

			System.out.print("\n " + msg);

			scanner = new Scanner(System.in);

			try {

				valor = new Integer(scanner.nextInt());

			} catch (InputMismatchException e) {

				System.out.println(ERROR_ACTION);

				flag = true;

			}

		} while (flag);

		// Saída da informação

		return valor;
	}

	@SuppressWarnings("resource")
	public static Integer validarIntNull(String msg) {

		// Declaração de variáveis

		Integer valor = null;

		String input = null;

		Scanner scanner = null;

		// Processamento dos dados

		scanner = new Scanner(System.in);

		System.out.print("\n " + msg);

		try {

			input = scanner.nextLine();

			if (!input.equals("")) {

				valor = Integer.parseInt(input);

			} else {

				valor = null;
			}

		} catch (NumberFormatException e) {
			// TODO: handle exception

			valor = null;
		}

		// Saída da informação

		return valor;

	}

	@SuppressWarnings("resource")
	public static Long validarLong(String msg) {

		// Declaração de variáveis

		Long valor = null;

		boolean flag = false;

		Scanner scanner = null;

		scanner = new Scanner(System.in);

		// Processamento dos dados

		do {

			flag = false;

			scanner = new Scanner(System.in);

			System.out.print("\n " + msg);

			try {

				valor = new Long(scanner.nextLong());

			} catch (InputMismatchException e) {
				// TODO: handle exception

				System.out.println(ERROR_ACTION);

				flag = true;
			}

		} while (flag);

		// Saída da informação

		return valor;
	}

	@SuppressWarnings("resource")
	public static Long validarLongNull(String msg) {

		// Declaração de variáveis

		Long valor = null;

		String input = null;

		Scanner scanner = null;

		// Processamento dos dados

		System.out.print("\n " + msg);

		try {

			scanner = new Scanner(System.in);

			input = scanner.nextLine();

			if (!input.equals("")) {

				valor = Long.parseLong(input);

			} else {

				valor = null;
			}

		} catch (NumberFormatException e) {
			// TODO: handle exception

			valor = null;
		}

		// Saída da informação

		return valor;
	}

	@SuppressWarnings("resource")
	public static Double validarDouble(String msg) {

		// Declaração de variáveis

		Double valor = null;

		String str = null;

		boolean flag = false;

		Scanner scanner = null;

		// Processamento dos dados

		do {

			flag = false;

			scanner = new Scanner(System.in);

			System.out.print("\n " + msg);

			str = scanner.nextLine();

			if (str.contains(",")) {

				str = str.replace(",", ".");
			}

			try {

				valor = new Double(Double.parseDouble(str));

			} catch (NumberFormatException e) {
				// TODO: handle exception

				System.out.println(ERROR_ACTION);

				flag = true;

			}

		} while (flag);

		// Saída da informação

		return valor;

	}

	@SuppressWarnings("resource")
	public static Double validarDoubleNull(String msg) {

		// Declaração de variáveis

		Double valor = null;

		String str = null;

		Scanner scanner = null;

		// Processamento dos dados

		scanner = new Scanner(System.in);

		System.out.print("\n " + msg);

		str = scanner.nextLine();

		if (str.contains(",")) {

			str = str.replace(",", ".");
		}

		try {

			valor = new Double(Double.parseDouble(str));

		} catch (NumberFormatException e) {
			// TODO: handle exception

			valor = null;
		}

		// Saída da informação

		return valor;

	}

	@SuppressWarnings("resource")
	public static String validarString(String msg) {

		// Declaração de variáveis

		String valor = null;

		boolean flag = false;

		Scanner scanner = null;

		// Processamento dos dados

		do {

			flag = false;

			scanner = new Scanner(System.in);

			System.out.print("\n " + msg);

			valor = scanner.nextLine();

			if (valor.equals("")) {

				System.out.println(ERROR_ACTION);

				flag = true;

			}

		} while (flag);

		// Saída da infomração

		return valor;
	}

	@SuppressWarnings("resource")
	public static String validarStringNull(String msg) {

		// Declaração de variáveis

		String valor = null;

		Scanner scanner = null;

		// Processamento dos dados

		scanner = new Scanner(System.in);

		System.out.print("\n " + msg);

		valor = scanner.nextLine();

		if (valor.equals("")) {

			valor = null;
		}

		// Saída da informação

		return valor;
	}

	@SuppressWarnings("resource")
	public static Date validarDate(String msg) {

		// Declaração de variáveis

		Date data = null;

		String str = null;

		boolean flag = false;

		Scanner scanner = null;

		// Processamento dos dados

		do {

			flag = false;

			scanner = new Scanner(System.in);

			System.out.print("\n " + msg);

			str = scanner.nextLine();

			data = convertStringToDate(str);

			if (data == null) {

				flag = true;

				System.out.println(ERROR_ACTION);
			}

		} while (flag);

		// Saída da informação

		return data;
	}

	@SuppressWarnings("resource")
	public static Date validarDateNull(String msg) {

		// Declaracao de vriáveis

		Date valor = null;

		String str = null;

		Scanner scanner = null;

		// Processamento dos dados

		scanner = new Scanner(System.in);

		System.out.print("\n " + msg);

		str = scanner.nextLine();

		valor = convertStringToDate(str);

		// Saída da informação

		return valor;
	}

	public static Date convertStringToDate(String source) {

		// Declaração de variáveis

		Date data = null;

		DateFormat formatador = null;

		// Inicialização de variáveis

		formatador = new SimpleDateFormat("dd/MM/yyyy");

		// Processamento dos dados

		try {

			data = formatador.parse(source);

		} catch (ParseException e) {
			// TODO: handle exception

			data = null;

		}

		// Saída da informação

		return data;
	}

}
