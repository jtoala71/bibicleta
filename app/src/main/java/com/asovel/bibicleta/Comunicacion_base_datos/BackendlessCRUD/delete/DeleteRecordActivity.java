package com.asovel.bibicleta.Comunicacion_base_datos.BackendlessCRUD.delete;

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

public class DeleteRecordActivity extends Activity
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

    String titleTemplate = getResources().getString( R.string.delete_title_template );
    String title = String.format( titleTemplate, table );
    titleView.setText( title );

    if( table.equals( "marca" ) )
    {
      code = getMarcaDeletionCode();
    }
    else if( table.equals( "eBike" ) )
    {
      code = getEBikeDeletionCode();
    }
    else if( table.equals( "tiendas" ) )
    {
      code = getTiendasDeletionCode();
    }
    else if( table.equals( "fabricante" ) )
    {
      code = getFabricanteDeletionCode();
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
      deleteMarcaRecord();
    }
    else if( table.equals( "eBike" ) )
    {
      deleteEBikeRecord();
    }
    else if( table.equals( "tiendas" ) )
    {
      deleteTiendasRecord();
    }
    else if( table.equals( "fabricante" ) )
    {
      deleteFabricanteRecord();
    }
  }

  private void onSendCodeButtonClicked()
  {
    Intent nextIntent = new Intent( getBaseContext(), SendEmailActivity.class );
    nextIntent.putExtra( "code", code );
    nextIntent.putExtra( "table", table );
    nextIntent.putExtra( "method", "Delete" );
    startActivity( nextIntent );
  }

  private String getMarcaDeletionCode()
  {
    return "public void remove( Marca marca )\n"
            + "{\n"
            + "  marca.removeAsync( new AsyncCallback<Long>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( Long deletionTime )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), \"Deletion time: \" + new Date( deletionTime ).toString(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void deleteMarcaRecord()
  {
    marca.findFirstAsync( new DefaultCallback<marca>( DeleteRecordActivity.this )
    {
      @Override
      public void handleResponse( marca response )
      {
        super.handleResponse( response );
        marca firstMarca = response;
        firstMarca.removeAsync( new DefaultCallback<Long>( DeleteRecordActivity.this )
        {
          @Override
          public void handleResponse( Long response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( getBaseContext(), DeleteSuccessActivity.class );
            nextIntent.putExtra( "time", response );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }

  private String getEBikeDeletionCode()
  {
    return "public void remove( EBike eBike )\n"
            + "{\n"
            + "  eBike.removeAsync( new AsyncCallback<Long>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( Long deletionTime )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), \"Deletion time: \" + new Date( deletionTime ).toString(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void deleteEBikeRecord()
  {
    eBike.findFirstAsync( new DefaultCallback<eBike>( DeleteRecordActivity.this )
    {
      @Override
      public void handleResponse( eBike response )
      {
        super.handleResponse( response );
        eBike firstEBike = response;
        firstEBike.removeAsync( new DefaultCallback<Long>( DeleteRecordActivity.this )
        {
          @Override
          public void handleResponse( Long response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( getBaseContext(), DeleteSuccessActivity.class );
            nextIntent.putExtra( "time", response );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }

  private String getTiendasDeletionCode()
  {
    return "public void remove( Tiendas tiendas )\n"
            + "{\n"
            + "  tiendas.removeAsync( new AsyncCallback<Long>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( Long deletionTime )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), \"Deletion time: \" + new Date( deletionTime ).toString(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void deleteTiendasRecord()
  {
    tiendas.findFirstAsync( new DefaultCallback<tiendas>( DeleteRecordActivity.this )
    {
      @Override
      public void handleResponse( tiendas response )
      {
        super.handleResponse( response );
        tiendas firstTiendas = response;
        firstTiendas.removeAsync( new DefaultCallback<Long>( DeleteRecordActivity.this )
        {
          @Override
          public void handleResponse( Long response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( getBaseContext(), DeleteSuccessActivity.class );
            nextIntent.putExtra( "time", response );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }

  private String getFabricanteDeletionCode()
  {
    return "public void remove( Fabricante fabricante )\n"
            + "{\n"
            + "  fabricante.removeAsync( new AsyncCallback<Long>()\n"
            + "  {\n"
            + "    @Override\n"
            + "    public void handleResponse( Long deletionTime )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), \"Deletion time: \" + new Date( deletionTime ).toString(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "    @Override\n"
            + "    public void handleFault( BackendlessFault fault )\n"
            + "    {\n"
            + "      Toast.makeText( getBaseContext(), fault.getMessage(), Toast.LENGTH_SHORT ).show();\n"
            + "    }\n"
            + "  }\n"
            + "}";
  }

  private void deleteFabricanteRecord()
  {
    fabricante.findFirstAsync( new DefaultCallback<fabricante>( DeleteRecordActivity.this )
    {
      @Override
      public void handleResponse( fabricante response )
      {
        super.handleResponse( response );
        fabricante firstFabricante = response;
        firstFabricante.removeAsync( new DefaultCallback<Long>( DeleteRecordActivity.this )
        {
          @Override
          public void handleResponse( Long response )
          {
            super.handleResponse( response );
            Intent nextIntent = new Intent( getBaseContext(), DeleteSuccessActivity.class );
            nextIntent.putExtra( "time", response );
            startActivity( nextIntent );
          }
        } );
      }
    } );
  }
}