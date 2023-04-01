# NOTE APP

**PROJE ÖZETİ:**

Not almak için geliştirilmiş arayüzü basit bir uygulama.

**İŞLEYİŞ:**

Uygulama açıldıktan sonra sağ alttaki '+' butonuna basarak not eklenir. Eklenen notlar 'Notlarım' sayfasında görüntülenir. Eğer eklenen nota basılırsa güncelleme yapılabilir ya da notu daha detaylı görüntülenir. 'Notlarım' ekranındayken cardview'a uzun basılı tutulduğunda sil seçeneği çıkar. Eğer sile basılırsa not 'Çöp Kutusu' sayfasına gönderilir. 'Çöp Kutusu' sayfasındayken eğer cardview'a basılırsa 'Notu geri yüklemek istediğinize emin misiniz?' diye bir custom dialog açılır. Eğer evet seçeneğine basılırsa not 'Notlarım' sayfasına gönderilir. Eğer hayır seçeneğine basılırsa dialog kapanır. Eğer 'Çöp Kutusu' sayfasındayken cardview'a uzun süre basılı tutulursa sil seçeneği çıkar. Eğer sil seçeneğine basılırsa bu sefer not tamamen silinir.

## Kullanılan teknoloji ve kütüphanler
  - Kotlin
  - Fragment
  - Navigation
  - RecyclerView
  - ViewBinding
  - Room Database
