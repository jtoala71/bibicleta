package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.update;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessData.*;
import com.asovel.bibicleta.R;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DataApplication;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.DefaultCallback;
import com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.common.SendEmailActivity;
import com.backendless.geo.GeoPoint;

import java.util.Collections;

import java.util.Random;
import java.util.UUID;

public class UpdateRecordActivity extends Activity
{
  private TextView titleView;
  private EditText codeView;
  private Button runCodeButton, sendCodeButton;

  private String code;
  private String table;

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
    codeView = (EditText) findViewById( R.id.sampleCodeEdit );
    runCodeButton = (Button) findViewById( R.id.runCodeButton );
    sendCodeButton = (Button) findViewById( R.id.sendCodeButton );

    String titleTemplate = getResources().getString( R.string.update_title_template );
    String title = String.format( titleTemplate, table );

    titleView.setText( title );

    if( table.equals( "marca" ) )
    {
      code = getMarcaUpdateCode();
    }
    else if( table.equals( "eBike" ) )
    {
      code = getEBikeUpdateCode();
    }
    else if( table.equals( "tiendas" ) )
    {
      code = getTiendasUpdateCode();
    }
    else if( table.equals( "fabricante" ) )
    {
      code = getFabricanteUpdateCode();
    }

    codeView.setText( code );

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
      updateMarcaRecord();
    }
    else if( table.equals( "eBike" ) )
    {
      updateEBikeRecord();
    }
    else if( table.equals( "tiendas" ) )
    {
      updateTiendasRecord();
    }
    else if( table.equals( "fabricante" ) )
    {
      updateFabricanteRecord();
    }
  }

  private void onSendCodeButtonClicked()
  {
    Intent nextIntent = new Intent( getBaseContext(), SendEmailActivity.class );
    nextIntent.putExtra( "code", code );
    nextIntent.putExtra( "table", table );
    nextIntent.putExtra( "method", "Update" );
    startActivity( nextIntent );
  }

  private String getMarcaUpdateCode()
  {
    return "public void update( marca marca )\n"
            + "{\n"
            + "  marca.setTipo_de_via( UUID.randomUUID().toString() );\n"
            + "  marca.setEmail( UUID.randomUUID().toString() );\n"
            + "  marca.setCodigo_postal( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "  marca.setPagina_web( UUID.randomUUID().toString() );\n"
            + "  marca.setTelefono( UUID.randomUUID().toString() );\n"
            + "  marca.setNumero( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "  marca.setPais( UUID.randomUUID().toString() );\n"
            + "  marca.setNombre_marca( UUID.randomUUID().toString() );\n"
            + "  marca.setCiudad( UUID.randomUUID().toString() );\n"
            + "  marca.setLogo( UUID.randomUUID().toString() );\n"
            + "  marca.setDireccion( UUID.randomUUID().toString() );\n"
            + "  marca.saveAsync( new AsyncCallback<marca>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( marca updatedRecord )\n"
            + "    {\n"
            + "      //work with object\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void updateMarcaRecord()
  {
    marca.findFirstAsync( new DefaultCallback<marca>( UpdateRecordActivity.this )
    {
      @Override
      public void handleResponse( marca response )
      {
        super.handleResponse( response );
        marca marca = response;
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

        marca.saveAsync( new DefaultCallback<marca>( UpdateRecordActivity.this )
        {
          @Override
          public void handleResponse( marca response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( UpdateRecordActivity.this, UpdateSuccessActivity.class );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }

  private String getEBikeUpdateCode()
  {
    return "public void update( eBike eBike )\n"
            + "{\n"
            + "  eBike.setSuspension( UUID.randomUUID().toString() );\n"
            + "  eBike.setTipo_sensor( UUID.randomUUID().toString() );\n"
            + "  eBike.setTipo_de_uso( UUID.randomUUID().toString() );\n"
            + "  eBike.setTipo_cuadro( UUID.randomUUID().toString() );\n"
            + "  eBike.setPrecio( UUID.randomUUID().toString() );\n"
            + "  eBike.setUbicacion_motor( UUID.randomUUID().toString() );\n"
            + "  eBike.setPuntos_de_venta( UUID.randomUUID().toString() );\n"
            + "  eBike.setPeso_total( UUID.randomUUID().toString() );\n"
            + "  eBike.setMaterial_del_cuadro( UUID.randomUUID().toString() );\n"
            + "  eBike.setVelocidades( UUID.randomUUID().toString() );\n"
            + "  eBike.setTipo_display( UUID.randomUUID().toString() );\n"
            + "  eBike.setFoto( UUID.randomUUID().toString() );\n"
            + "  eBike.setAutonomia( UUID.randomUUID().toString() );\n"
            + "  eBike.setPagina_web( UUID.randomUUID().toString() );\n"
            + "  eBike.setModelo( UUID.randomUUID().toString() );\n"
            + "  eBike.setTamano_ruedas( UUID.randomUUID().toString() );\n"
            + "  eBike.saveAsync( new AsyncCallback<eBike>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( eBike updatedRecord )\n"
            + "    {\n"
            + "      //work with object\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void updateEBikeRecord()
  {
    eBike.findFirstAsync( new DefaultCallback<eBike>( UpdateRecordActivity.this )
    {
      @Override
      public void handleResponse( eBike response )
      {
        super.handleResponse( response );
        eBike eBike = response;
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

        eBike.saveAsync( new DefaultCallback<eBike>( UpdateRecordActivity.this )
        {
          @Override
          public void handleResponse( eBike response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( UpdateRecordActivity.this, UpdateSuccessActivity.class );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }

  private String getTiendasUpdateCode()
  {
    return "public void update( tiendas tiendas )\n"
            + "{\n"
            + "  tiendas.setNombre( UUID.randomUUID().toString() );\n"
            + "  tiendas.setCiudad( UUID.randomUUID().toString() );\n"
            + "  tiendas.setPais( UUID.randomUUID().toString() );\n"
            + "  tiendas.setTipo_de_via( UUID.randomUUID().toString() );\n"
            + "  tiendas.setPagina_web( UUID.randomUUID().toString() );\n"
            + "  tiendas.setCodigo_postal( UUID.randomUUID().toString() );\n"
            + "  tiendas.setEmail( UUID.randomUUID().toString() );\n"
            + "  tiendas.setTelefono( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "  tiendas.setNombre_fabricante( UUID.randomUUID().toString() );\n"
            + "  tiendas.setLatitud( UUID.randomUUID().toString() );\n"
            + "  tiendas.setNumero( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "  tiendas.setDireccion( UUID.randomUUID().toString() );\n"
            + "  tiendas.setLongitud( UUID.randomUUID().toString() );\n"
            + "  tiendas.saveAsync( new AsyncCallback<tiendas>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( tiendas updatedRecord )\n"
            + "    {\n"
            + "      //work with object\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void updateTiendasRecord()
  {
    tiendas.findFirstAsync( new DefaultCallback<tiendas>( UpdateRecordActivity.this )
    {
      @Override
      public void handleResponse( tiendas response )
      {
        super.handleResponse( response );
        tiendas tiendas = response;
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

        tiendas.saveAsync( new DefaultCallback<tiendas>( UpdateRecordActivity.this )
        {
          @Override
          public void handleResponse( tiendas response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( UpdateRecordActivity.this, UpdateSuccessActivity.class );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }

  private String getFabricanteUpdateCode()
  {
    return "public void update( fabricante fabricante )\n"
            + "{\n"
            + "  fabricante.setCodigo_postal( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "  fabricante.setCiudad( UUID.randomUUID().toString() );\n"
            + "  fabricante.setPais( UUID.randomUUID().toString() );\n"
            + "  fabricante.setEmail( UUID.randomUUID().toString() );\n"
            + "  fabricante.setNombre_fabricante( UUID.randomUUID().toString() );\n"
            + "  fabricante.setNumero( new Random().nextInt( (int) (Math.pow( 2, 29 ) / 2 - 1) ) );\n"
            + "  fabricante.setTelefono( UUID.randomUUID().toString() );\n"
            + "  fabricante.setTipo_de_via( UUID.randomUUID().toString() );\n"
            + "  fabricante.setDireccion( UUID.randomUUID().toString() );\n"
            + "  fabricante.setPagina_web( UUID.randomUUID().toString() );\n"
            + "  fabricante.saveAsync( new AsyncCallback<fabricante>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( fabricante updatedRecord )\n"
            + "    {\n"
            + "      //work with object\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void updateFabricanteRecord()
  {
    fabricante.findFirstAsync( new DefaultCallback<fabricante>( UpdateRecordActivity.this )
    {
      @Override
      public void handleResponse( fabricante response )
      {
        super.handleResponse( response );
        fabricante fabricante = response;
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

        fabricante.saveAsync( new DefaultCallback<fabricante>( UpdateRecordActivity.this )
        {
          @Override
          public void handleResponse( fabricante response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( UpdateRecordActivity.this, UpdateSuccessActivity.class );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }
}