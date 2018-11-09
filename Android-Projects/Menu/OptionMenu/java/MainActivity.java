public boolean onCreateOptionsMenu(Menu menu) {  
  MenuInflater inflater = getMenuInflater();
  inflater.inflate(R.menu.example_menu, menu);
  return true;  
}  
  
@Override  
public boolean onOptionsItemSelected(MenuItem item) {  
   int id = item.getItemId();  
    switch (id){  
        case R.id.item1:  
            Toast.makeText(getApplicationContext(),"Item 1 Selected",Toast.LENGTH_LONG).show();  
            return true;  
        case R.id.item2:  
            Toast.makeText(getApplicationContext(),"Item 2 Selected",Toast.LENGTH_LONG).show();  
            return true;  
        case R.id.item3:  
            Toast.makeText(getApplicationContext(),"Item 3 Selected",Toast.LENGTH_LONG).show();  
            return true;  
        default:  
            return super.onOptionsItemSelected(item);  
    }  
}  
