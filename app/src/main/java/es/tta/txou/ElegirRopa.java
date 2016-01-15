package es.tta.txou;

/**
 * Created by jone on 14/01/16.
 */
public class ElegirRopa
{

    private static boolean[] ropa = {false,false,false,false};//new boolean[4];//Guantes, falda, pantalon, bufanda

    public static boolean[] cambiarRopa(int prenda)//0->guantes, 1->falda, 2->pantalon, 3->bufanda
    {

        switch (prenda)
        {
            case 0://se ha elegido guantes
                if (ropa[0])//comprobar si los lleva puestos
                    ropa[0] = false;//si están puestos, quitarlos
                else
                    ropa[0]=true;//si no están puestos, se los ponemos
                break;

            case 1:// se ha elegido falda
                if (ropa[1])//comprobar si los lleva puestos
                    ropa[1] = false;//si están puestos, quitarlos
                else
                    ropa[1]=true;//si no están puestos, se los ponemos
                break;

            case 2://se ha elegido pantalon
                if (ropa[2])//comprobar si los lleva puestos
                    ropa[2] = false;//si están puestos, quitarlos
                else
                    ropa[2]=true;//si no están puestos, se los ponemos
                break;

            case 3://se ha elegido bufanda
                if (ropa[3])//comprobar si los lleva puestos
                    ropa[3] = false;//si están puestos, quitarlos
                else
                    ropa[3]=true;//si no están puestos, se los ponemos
                break;

        }

        return ropa;
    }

    public static int elegirImagen()
    {
        int cont=0;
        int devolver=R.drawable.txou_normal;
        for(int i=0;i<ropa.length;i++)
        {
            if(ropa[i])
                cont++;
        }

        //Solo lleva una prenda:
        if (cont==1)
        {
            if (ropa[0])
                devolver= R.drawable.txou_guantes;//devolver imagen con guantes
            if (ropa[1])
                devolver= R.drawable.txou_falda;//devolver imagen con falda
            if (ropa[2])
                devolver= R.drawable.txou_pantalones;//devolver imagen con pantalones
            if (ropa[3])
                devolver= R.drawable.txou_bufanda;//devolver imagen con bufanda
        }
        //lleva dos prenda
        if (cont==2)
        {
            if (ropa[0]&&ropa[1])
                devolver= R.drawable.txou_guantes_falda;//devolver imagen con guantes y falda
            if (ropa[0]&&ropa[2])
                devolver= R.drawable.txou_guantes_pantalon;//devolver imagen con guantes y pantalon
            if (ropa[0]&&ropa[3])
                devolver= R.drawable.txou_guantes_bufanda;//devolver imagen con guantes y bufanda
            if (ropa[1]&&ropa[3])
                devolver= R.drawable.txou_falda_bufanda;//devolver imagen con falda y bufanda
            if (ropa[2]&&ropa[3])
                devolver= R.drawable.txou_pantalon_bufanda;//devolver imagen con pantalon y bufanda
            if (ropa[1]&&ropa[2])
            {
                devolver = R.drawable.txou_normal;//kontuz, galtzak eta gona ezin dira batera jarri
                ropa[0]=false;
                ropa[1]=false;
                ropa[2]=false;
                ropa[3]=false;
            }
        }
        if (cont==3)
        {
            if (ropa[2])
                devolver= R.drawable.txou_guantes_bufanda_pantalon;//devolver imagen con guantes, bufanda y pantalon
            if (ropa[1])
                devolver= R.drawable.txou_guantes_bufanda_falda;
            if(ropa[1]&&ropa[2])
            {
                ropa[1]=false;
                ropa[2]=false;
                devolver=R.drawable.txou_normal;
            }
        }

        return devolver;

    }
}
