package android.example.com.printingtwo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintManager;
import android.util.Log;
import android.view.View;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printPDF(View view) {

        PrintManager printManager = (PrintManager)getSystemService(Context.PRINT_SERVICE);
        RetrievingFile file_in = new RetrievingFile();
        try{
            PrintDocumentAdapter printDocumentAdapter = new PdfDocumentAdapter(MainActivity.this);
            printManager.print("Document", printDocumentAdapter, new PrintAttributes.Builder().build());
            file_in.getPDF();

        } catch(Exception ex){
            Log.e("PINTERIN", ""+ex.getMessage());
        }
    }
}
