package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.create;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessData.*;
import com.asovel.bibicleta.R;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DataApplication;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DefaultCallback;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.SendEmailActivity;
import com.backendless.geo.GeoPoint;

import java.util.ArrayList;
import java.util.Collections;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CreateRecordActivity extends Activity
{
  private TextView titleView;
  private EditText codeEdit;
  private Button runCodeButton, sendCodeButton;

  private String code;
  private String table;

                                    
  class CreatemarcaRecordTask extends AsyncTask<Void, Void, marca>
  {
    marca marca = new marca();

    @Override
    protected void onPreExecute()
    {
      marca.setTipo_de_via( UUID.randomUUID().toString() );
      marca.setEmail( UUID.randomUUID().toString() );
      marca.setCodigo_postal( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );
      marca.setPagina_web( UUID.randomUUID().toString() );
      marca.setTelefono( UUID.randomUUID().toString() );
      marca.setNumero( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );
      marca.setPais( UUID.randomUUID().toString() );
      marca.setNombre_marca( UUID.randomUUID().toString() );
      marca.setCiudad( UUID.randomUUID().toString() );
      marca.setLogo( UUID.randomUUID().toString() );
      marca.setDireccion( UUID.randomUUID().toString() );
      marca.setModelo_eBike( new ArrayList<eBike>() );
      marca.setNombre_fabricante( new ArrayList<fabricante>() );
    }

    @Override
    protected marca doInBackground( Void... voids )
    {
      return marca.save();
    }
  }

  class CreateeBikeRecordTask extends AsyncTask<Void, Void, eBike>
  {
    eBike eBike = new eBike();

    @Override
    protected void onPreExecute()
    {
      eBike.setSuspension( UUID.randomUUID().toString() );
      eBike.setTipo_sensor( UUID.randomUUID().toString() );
      eBike.setTipo_de_uso( UUID.randomUUID().toString() );
      eBike.setTipo_cuadro( UUID.randomUUID().toString() );
      eBike.setPrecio( UUID.randomUUID().toString() );
      eBike.setUbicacion_motor( UUID.randomUUID().toString() );
      eBike.setPuntos_de_venta( UUID.randomUUID().toString() );
      eBike.setPeso_total( UUID.randomUUID().toString() );
      eBike.setMaterial_del_cuadro( UUID.randomUUID().toString() );
      eBike.setVelocidades( UUID.randomUUID().toString() );
      eBike.setTipo_display( UUID.randomUUID().toString() );
      eBike.setFoto( UUID.randomUUID().toString() );
      eBike.setAutonomia( UUID.randomUUID().toString() );
      eBike.setPagina_web( UUID.randomUUID().toString() );
      eBike.setModelo( UUID.randomUUID().toString() );
      eBike.setTamano_ruedas( UUID.randomUUID().toString() );
      eBike.setMarca( new ArrayList<tiendas>() );
    }

    @Override
    protected eBike doInBackground( Void... voids )
    {
      return eBike.save();
    }
  }

  class CreatetiendasRecordTask extends AsyncTask<Void, Void, tiendas>
  {
    tiendas tiendas = new tiendas();

    @Override
    protected void onPreExecute()
    {
      tiendas.setNombre( UUID.randomUUID().toString() );
      tiendas.setCiudad( UUID.randomUUID().toString() );
      tiendas.setPais( UUID.randomUUID().toString() );
      tiendas.setTipo_de_via( UUID.randomUUID().toString() );
      tiendas.setPagina_web( UUID.randomUUID().toString() );
      tiendas.setCodigo_postal( UUID.randomUUID().toString() );
      tiendas.setEmail( UUID.randomUUID().toString() );
      tiendas.setTelefono( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );
      tiendas.setNombre_fabricante( UUID.randomUUID().toString() );
      tiendas.setLatitud( UUID.randomUUID().toString() );
      tiendas.setNumero( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );
      tiendas.setDireccion( UUID.randomUUID().toString() );
      tiendas.setLongitud( UUID.randomUUID().toString() );
    }

    @Override
    protected tiendas doInBackground( Void... voids )
    {
      return tiendas.save();
    }
  }

  class CreatefabricanteRecordTask extends AsyncTask<Void, Void, fabricante>
  {
    fabricante fabricante = new fabricante();

    @Override
    protected void onPreExecute()
    {
      fabricante.setCodigo_postal( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );
      fabricante.setCiudad( UUID.randomUUID().toString() );
      fabricante.setPais( UUID.randomUUID().toString() );
      fabricante.setEmail( UUID.randomUUID().toString() );
      fabricante.setNombre_fabricante( UUID.randomUUID().toString() );
      fabricante.setNumero( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );
      fabricante.setTelefono( UUID.randomUUID().toString() );
      fabricante.setTipo_de_via( UUID.randomUUID().toString() );
      fabricante.setDireccion( UUID.randomUUID().toString() );
      fabricante.setPagina_web( UUID.randomUUID().toString() );
    }

    @Override
    protected fabricante doInBackground( Void... voids )
    {
      return fabricante.save();
    }
  }


  public void onCreate( Bundle savedInstanceState )
  {
    super.onCreate( savedInstanceState );
    setContentView( R.layout.sample_code_template );

    DataApplication dataApplication = (DataApplication) getApplication();
    table = dataApplication.getChosenTable();

    initUI();
  }

  private void initUI()
  {
    titleView = (TextView) findViewById( R.id.sampleCodeTitle );
    codeEdit = (EditText) findViewById( R.id.sampleCodeEdit );
    runCodeButton = (Button) findViewById( R.id.runCodeButton );
    sendCodeButton = (Button) findViewById( R.id.sendCodeButton );

    String titleTemplate = getResources().getString( R.string.create_record_title_template );
    String title = String.format( titleTemplate, table );
    titleView.setText( title );

    if( table.equals( "marca" ) )
    {
      code = getMarcaCreationCode();
    }
    else if( table.equals( "eBike" ) )
    {
      code = getEBikeCreationCode();
    }
    else if( table.equals( "tiendas" ) )
    {
      code = getTiendasCreationCode();
    }
    else if( table.equals( "fabricante" ) )
    {
      code = getFabricanteCreationCode();
    }

    codeEdit.setText( code );

    runCodeButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        onRunCodeButtonClicked();
      }
    } );

    sendCodeButton.setOnClickListener( new View.OnClickListener()
    {
      @Override
      public void onClick( View view )
      {
        onSendCodeButtonClicked();
      }
    } );
  }

  private void onRunCodeButtonClicked()
  {
    if( table.equals( "marca" ) )
    {
      createMarcaRecord();
    }
    else if( table.equals( "eBike" ) )
    {
      createEBikeRecord();
    }
    else if( table.equals( "tiendas" ) )
    {
      createTiendasRecord();
    }
    else if( table.equals( "fabricante" ) )
    {
      createFabricanteRecord();
    }
  }

  private void onSendCodeButtonClicked()
  {
    Intent nextIntent = new Intent( getBaseContext(), SendEmailActivity.class );
    nextIntent.putExtra( "code", code );
    nextIntent.putExtra( "table", table );
    nextIntent.putExtra( "method", "Create" );
    startActivity( nextIntent );
  }

  private String getMarcaCreationCode()
  {
    return "marca marca = new marca();\n"
            + "marca.setTipo_de_via( UUID.randomUUID().toString() );\n"
            + "marca.setEmail( UUID.randomUUID().toString() );\n"
            + "marca.setCodigo_postal( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "marca.setPagina_web( UUID.randomUUID().toString() );\n"
            + "marca.setTelefono( UUID.randomUUID().toString() );\n"
            + "marca.setNumero( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "marca.setPais( UUID.randomUUID().toString() );\n"
            + "marca.setNombre_marca( UUID.randomUUID().toString() );\n"
            + "marca.setCiudad( UUID.randomUUID().toString() );\n"
            + "marca.setLogo( UUID.randomUUID().toString() );\n"
            + "marca.setDireccion( UUID.randomUUID().toString() );\n"
            + "marca.saveAsync( new AsyncCallback<marca>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( marca savedMarca )\n"
            + "  {\n"
            + "    marca = savedMarca;\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "});";
  }

  private void createMarcaRecord()
  {
    marca marca = null;

    try
    {
      marca = new CreatemarcaRecordTask().execute().get( 30, TimeUnit.SECONDS );
    }
    catch ( Exception e )
    {
      Toast.makeText( this, e.getMessage(), Toast.LENGTH_SHORT ).show();
      return;
    }

    Intent nextIntent = new Intent( CreateRecordActivity.this, CreateSuccessActivity.class );
    startActivity( nextIntent );
  }

  private String getEBikeCreationCode()
  {
    return "eBike eBike = new eBike();\n"
            + "eBike.setSuspension( UUID.randomUUID().toString() );\n"
            + "eBike.setTipo_sensor( UUID.randomUUID().toString() );\n"
            + "eBike.setTipo_de_uso( UUID.randomUUID().toString() );\n"
            + "eBike.setTipo_cuadro( UUID.randomUUID().toString() );\n"
            + "eBike.setPrecio( UUID.randomUUID().toString() );\n"
            + "eBike.setUbicacion_motor( UUID.randomUUID().toString() );\n"
            + "eBike.setPuntos_de_venta( UUID.randomUUID().toString() );\n"
            + "eBike.setPeso_total( UUID.randomUUID().toString() );\n"
            + "eBike.setMaterial_del_cuadro( UUID.randomUUID().toString() );\n"
            + "eBike.setVelocidades( UUID.randomUUID().toString() );\n"
            + "eBike.setTipo_display( UUID.randomUUID().toString() );\n"
            + "eBike.setFoto( UUID.randomUUID().toString() );\n"
            + "eBike.setAutonomia( UUID.randomUUID().toString() );\n"
            + "eBike.setPagina_web( UUID.randomUUID().toString() );\n"
            + "eBike.setModelo( UUID.randomUUID().toString() );\n"
            + "eBike.setTamano_ruedas( UUID.randomUUID().toString() );\n"
            + "eBike.saveAsync( new AsyncCallback<eBike>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( eBike savedEBike )\n"
            + "  {\n"
            + "    eBike = savedEBike;\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "});";
  }

  private void createEBikeRecord()
  {
    eBike eBike = null;

    try
    {
      eBike = new CreateeBikeRecordTask().execute().get( 30, TimeUnit.SECONDS );
    }
    catch ( Exception e )
    {
      Toast.makeText( this, e.getMessage(), Toast.LENGTH_SHORT ).show();
      return;
    }

    Intent nextIntent = new Intent( CreateRecordActivity.this, CreateSuccessActivity.class );
    startActivity( nextIntent );
  }

  private String getTiendasCreationCode()
  {
    return "tiendas tiendas = new tiendas();\n"
            + "tiendas.setNombre( UUID.randomUUID().toString() );\n"
            + "tiendas.setCiudad( UUID.randomUUID().toString() );\n"
            + "tiendas.setPais( UUID.randomUUID().toString() );\n"
            + "tiendas.setTipo_de_via( UUID.randomUUID().toString() );\n"
            + "tiendas.setPagina_web( UUID.randomUUID().toString() );\n"
            + "tiendas.setCodigo_postal( UUID.randomUUID().toString() );\n"
            + "tiendas.setEmail( UUID.randomUUID().toString() );\n"
            + "tiendas.setTelefono( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "tiendas.setNombre_fabricante( UUID.randomUUID().toString() );\n"
            + "tiendas.setLatitud( UUID.randomUUID().toString() );\n"
            + "tiendas.setNumero( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "tiendas.setDireccion( UUID.randomUUID().toString() );\n"
            + "tiendas.setLongitud( UUID.randomUUID().toString() );\n"
            + "tiendas.saveAsync( new AsyncCallback<tiendas>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( tiendas savedTiendas )\n"
            + "  {\n"
            + "    tiendas = savedTiendas;\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "});";
  }

  private void createTiendasRecord()
  {
    tiendas tiendas = null;

    try
    {
      tiendas = new CreatetiendasRecordTask().execute().get( 30, TimeUnit.SECONDS );
    }
    catch ( Exception e )
    {
      Toast.makeText( this, e.getMessage(), Toast.LENGTH_SHORT ).show();
      return;
    }

    Intent nextIntent = new Intent( CreateRecordActivity.this, CreateSuccessActivity.class );
    startActivity( nextIntent );
  }

  private String getFabricanteCreationCode()
  {
    return "fabricante fabricante = new fabricante();\n"
            + "fabricante.setCodigo_postal( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "fabricante.setCiudad( UUID.randomUUID().toString() );\n"
            + "fabricante.setPais( UUID.randomUUID().toString() );\n"
            + "fabricante.setEmail( UUID.randomUUID().toString() );\n"
            + "fabricante.setNombre_fabricante( UUID.randomUUID().toString() );\n"
            + "fabricante.setNumero( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "fabricante.setTelefono( UUID.randomUUID().toString() );\n"
            + "fabricante.setTipo_de_via( UUID.randomUUID().toString() );\n"
            + "fabricante.setDireccion( UUID.randomUUID().toString() );\n"
            + "fabricante.setPagina_web( UUID.randomUUID().toString() );\n"
            + "fabricante.saveAsync( new AsyncCallback<fabricante>()\n"
            + "{\n"
            + "  @Override\n"
            + "  public void handleResponse( fabricante savedFabricante )\n"
            + "  {\n"
            + "    fabricante = savedFabricante;\n"
            + "  }\n"
            + "  @Override\n"
            + "  public void handleFault( BackendlessFault fault )\n"
            + "  {\n"
            + "    Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "  }\n"
            + "});";
  }

  private void createFabricanteRecord()
  {
    fabricante fabricante = null;

    try
    {
      fabricante = new CreatefabricanteRecordTask().execute().get( 30, TimeUnit.SECONDS );
    }
    catch ( Exception e )
    {
      Toast.makeText( this, e.getMessage(), Toast.LENGTH_SHORT ).show();
      return;
    }

    Intent nextIntent = new Intent( CreateRecordActivity.this, CreateSuccessActivity.class );
    startActivity( nextIntent );
  }
}