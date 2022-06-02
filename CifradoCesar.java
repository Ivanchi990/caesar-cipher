Scanner sc = new Scanner(System.in);

char alfabeto[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
char cifrado[] = {'d', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'a', 'b', 'c'};

System.out.println("Introduce el nombre del fichero: \n");
String nombre = sc.nextLine();

File fichero1 = new File(nombre);
File fichero2 = new File("secreto_" + fichero1.getName());

FileOutputStream fos = null;
FileInputStream fis = null;

try
{
	fichero2.createNewFile();

	fis = new FileInputStream(fichero1);
	fos = new FileOutputStream(fichero2);

	int l = 0;

	while((l = fis.read()) != -1)
	{
		char letra = (char)l;

		if(Character.isAlphabetic(letra))
		{
			for(int i = 0; i < alfabeto.length; i++)
			{
				if(alfabeto[i] == letra)
				{
					fos.write(cifrado[i]);
				}
			}
		}
		else
		{
			fos.write(letra);
		}
	}

	fis.close();
	fos.close();
} catch(IOException e)
{
	System.err.println(e.getMessage());
}

System.out.println("Fin");
}
