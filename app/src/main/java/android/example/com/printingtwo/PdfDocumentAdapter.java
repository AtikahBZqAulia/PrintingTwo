package android.example.com.printingtwo;

import android.content.ContentValues;
import android.content.Context;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import androidx.annotation.NonNull;

class PdfDocumentAdapter extends PrintDocumentAdapter{
    Context context;
    String path;

    public PdfDocumentAdapter(Context context) {
        this.context = context;
        this.path = path;
    }

    @Override
    public void onLayout(PrintAttributes oldAttributes, PrintAttributes newAttributes, CancellationSignal cancellationSignal, LayoutResultCallback callback, Bundle extras) {
        if(cancellationSignal.isCanceled())
            callback.onLayoutCancelled();
        else{
            PrintDocumentInfo.Builder builder = new PrintDocumentInfo.Builder("filename");
            builder.setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                    .setPageCount(PrintDocumentInfo.PAGE_COUNT_UNKNOWN)
                    .build();
            callback.onLayoutFinished(builder.build(), newAttributes.equals(newAttributes) );
        }


    }

    @Override
    public void onWrite(PageRange[] pages, ParcelFileDescriptor destination, CancellationSignal cancellationSignal, WriteResultCallback callback) {
//        InputStream in = null;
//        OutputStream out = null;
//        try{
//            File file = new File(path);
//            in = new FileInputStream(file);
//            out = new FileOutputStream();
//            byte[] buff = new byte[16304];
//            int size;
//            while((size=in.read(buff)) >= 0 && !cancellationSignal.isCanceled()){
//                out.write(buff, 0, size);
//            }
//            if(cancellationSignal.isCanceled())
//                callback.onWriteCancelled();
//            else{
//                callback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});
//            }
//        }catch (Exception e) {
//            callback.onWriteFailed(e.getMessage());
//            Log.e("PINTER", e.getMessage());
//            e.printStackTrace();
//        }
//        finally {
//            try{
//                in.close();
//                out.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

    }

}
