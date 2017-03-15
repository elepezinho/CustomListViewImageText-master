package androidinterview.com.customlistviewimagetext;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity{
	
	ListView list;
	String[] itemname ={
			"Safari",
			"Camera",
			"Global",
			"FireFox",
			"UC Browser",
			"Android Folder",
			"VLC Player",
			"Cold War"
		};
	
	Integer[] imgid={
			R.drawable.pic1,
			R.drawable.pic2,
			R.drawable.pic3,
			R.drawable.pic4,
			R.drawable.pic5,
			R.drawable.pic6,
			R.drawable.pic7,
			R.drawable.pic8,
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		CustomListAdapter adapter=new CustomListAdapter(this, itemname, imgid);
		list=(ListView)findViewById(R.id.list);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				String Slecteditem= itemname[+position];
				Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
				
			}
		});


		ListView lv = (ListView) findViewById(R.id.list);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(chamaLivros());
	}

	public AdapterView.OnItemClickListener chamaLivros() {
		return (new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> av, View v, int position, long id) {
				Intent intent;

				switch (position){
					case 0:
						intent  = new Intent(getBaseContext(),Livro01.class);
						startActivity(intent);
						break;

					case 1:
						Intent browserIntent = new Intent(Intent.ACTION_VIEW);
						Uri.parse("https://www.amazon.com.br/dp/B008A6K96G/ref=asc_df_B008A6K96G4892279?smid=A1ZZFT5FULY4LN&tag=goog0ef-20&linkCode=asn&creative=380341&creativeASIN=B008A6K96G");
						startActivity (browserIntent);
						break;

					case 2:
						intent = new Intent (getBaseContext(),Livro01.class);
						startActivity(intent);
						break;

				}
			}
		});
	}

}
