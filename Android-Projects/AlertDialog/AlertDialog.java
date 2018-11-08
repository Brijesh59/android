AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
builder.setTitle("Your Title");
builder.setMessage("Your Message");
builder.setCancelable(true);

builder.setPositiveButton( "Yes", new DialogInterface.OnClickListener() {
  public void onClick(DialogInterface dialog, int id) {
    // do what so ever
  }
});

builder.setNegativeButton( "No", new DialogInterface.OnClickListener() {
  public void onClick(DialogInterface dialog, int id) {
    dialog.cancel();
  }
});

builder.create().show();
