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
 * Classe utilit�ria para a valida��o de entrada de dados.
 * 
 * @author Baracho
 * 
 * @since 03/04/2014
 * 
 * @version 3.0
 * 
 */
public class Util {

	// Vari�veis de inst�ncia

	private final static String ERROR_ACTION = "\n Valor Inv�lido!"
			+ " Digite Novamente.";

	// Fun��o construtora

	public Util() {

	}

	// Opera��es da Classe

	@SuppressWarnings("resource")
	public static Character validarCharacter(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da do m�todo

		return valor;
	}

	@SuppressWarnings("resource")
	public static Character validarCharacterNull(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da da informa��o

		return valor;

	}

	@SuppressWarnings("resource")
	public static Integer validarInt(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da da informa��o

		return valor;
	}

	@SuppressWarnings("resource")
	public static Integer validarIntNull(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da da informa��o

		return valor;

	}

	@SuppressWarnings("resource")
	public static Long validarLong(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da da informa��o

		return valor;
	}

	@SuppressWarnings("resource")
	public static Long validarLongNull(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da da informa��o

		return valor;
	}

	@SuppressWarnings("resource")
	public static Double validarDouble(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da da informa��o

		return valor;

	}

	@SuppressWarnings("resource")
	public static Double validarDoubleNull(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da da informa��o

		return valor;

	}

	@SuppressWarnings("resource")
	public static String validarString(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da da infomra��o

		return valor;
	}

	@SuppressWarnings("resource")
	public static String validarStringNull(String msg) {

		// Declara��o de vari�veis

		String valor = null;

		Scanner scanner = null;

		// Processamento dos dados

		scanner = new Scanner(System.in);

		System.out.print("\n " + msg);

		valor = scanner.nextLine();

		if (valor.equals("")) {

			valor = null;
		}

		// Sa�da da informa��o

		return valor;
	}

	@SuppressWarnings("resource")
	public static Date validarDate(String msg) {

		// Declara��o de vari�veis

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

		// Sa�da da informa��o

		return data;
	}

	@SuppressWarnings("resource")
	public static Date validarDateNull(String msg) {

		// Declaracao de vri�veis

		Date valor = null;

		String str = null;

		Scanner scanner = null;

		// Processamento dos dados

		scanner = new Scanner(System.in);

		System.out.print("\n " + msg);

		str = scanner.nextLine();

		valor = convertStringToDate(str);

		// Sa�da da informa��o

		return valor;
	}

	public static Date convertStringToDate(String source) {

		// Declara��o de vari�veis

		Date data = null;

		DateFormat formatador = null;

		// Inicializa��o de vari�veis

		formatador = new SimpleDateFormat("dd/MM/yyyy");

		// Processamento dos dados

		try {

			data = formatador.parse(source);

		} catch (ParseException e) {
			// TODO: handle exception

			data = null;

		}

		// Sa�da da informa��o

		return data;
	}

}
