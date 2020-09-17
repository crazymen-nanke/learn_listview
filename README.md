## ListView的使用

使用了SimpleAdapter和BaseAdapter。

项目树：

![image-20200917175551876](C:\Users\Admin\AppData\Roaming\Typora\typora-user-images\image-20200917175551876.png)

SimpleAdapter的使用范例：

```java
...
     private ActivityMainBinding binding;
    //模拟数据
    String[] text = {"花卉1", "花卉2", "花卉3", "花卉4"};
...

//使用SimpleAdapter,这个适配器只可以装配一些简单的数据（数据类型单一）
 private void setListViewBySimpleAdapter() {

        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < text.length; i++) {
            Map<String, String> map = new HashMap<>();
            map.put("text", text[i]);
            list.add(map);
        }
        SimpleAdapter adapter = new SimpleAdapter(MainActivity.this, list, R.layout.listview_item, new String[]{"text"}, new int[]{R.id.textView});
        binding.listView.setAdapter(adapter);
        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, text[position], Toast.LENGTH_SHORT).show();
            }
        });
    }
```

效果图：

![image-20200917175006526](https://zl.crazymen.cn/images/image-20200917175006526.png)



BaseAdapter的使用：

使用BaseAdapter的时候，我们大多数情况下是需要将适配器类进行封装，并且使用JavaBean对象封装数据。

适配器类写法也简单，首先让这个类继承自BaseAdapter，然后重写BaseAdapter中需要我们实现的四个方法，如果没有特殊需求，我们重写的四个方法中只需要关心getView()这一个方法。其次为了对ListView进行优化处理，我们可以创建ViewHold类和利用其自身的缓存机制。最后我们需要创建类型与JavaBean对象一致的集合，以及创建一个上下文对象（Context类型），并且生成关于这两者的构造器。

详细代码请参阅Github：https://github.com/crazymen-nanke/learn_listview



效果图：

![image-20200917175232136](https://zl.crazymen.cn/images/image-20200917175232136.png)

