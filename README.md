# BİL 2002 Nesneye Yönelik Programlama
## Proje 2 Teslim Tarihi: 12 Haziran 2019 Çarşamba 21:30 (GitHub üzerinden)
### (2 veya 3 kişilik gruplar halinde)
Önemli Kural ve Koşullar:
-	Projeye ilişkin tüm kaynak kodlar, dosyalar, dizinler, açıklama/referans metinleri GitHub üzerinden yüklenecektir. Her gruptaki öğrencilerin farklı yüklemeleri değerlendirileceği için, projenizde sadece tek bir öğrencinin aktivitelerinin bulunması durumunda diğer grup üyeleri not alamayacaktır.
-	Proje teslimi için ek süre kesinlikle verilmeyecektir. Herhangi bir nedenle zamanında iletilmeyen projeler, hiçbir mazeret kabul edilmeden 0 (sıfır) olarak notlandırılacaktır.
-	Farklı proje ekiplerinin birbirinden ya da üçüncü şahıslardan kopya / intihal durumu belirlendiğinde, ilgili tüm proje ekiplerindeki öğrenciler projeden 0 (sıfır) alarak ilgili üniversite yönetmeliği çerçevesinde değerlendirileceklerdir.
-	Projenizde C#, Java veya C++ programlama dillerinden herhangi bir tanesini kullanabilirsiniz. Projelerinizin derlenebilmesi ve çalıştırılabilmesi için gereken ekstra bilgilerin belirtilmesi proje gruplarının sorumluluğundadır. Farklı kurulum gerektiren projeler değerlendirilmeyecektir.
-	Projelerinize not verilip değerlendirilirken Proje 1 için belirtilen teknik gereksinim ve kıstaslara yine dikkat edilecektir.
-	Kodunuzda gerekli tüm yerlerde açıklama (commenting) yapmayı ihmal etmeyiniz.

<b>Proje Konusu (lütfen sonuna kadar okuyunuz)</b>

<b>DEÜ-CSC El Turistiko A.Ş.:</b>

Bu projede istenen rezervasyon sistemi, sisteme giriş yapan kullanıcıların otel odası rezervasyonu gerçekleştirebilecekleri veya yapılan rezervasyon bilgilerini görüntüleyecek bir yazılım uygulamasıdır.
Kullanıcıların işlem yapabilmesi için öncelikle sisteme üye olmaları gerekmektedir. Üyeler sisteme kendilerine ait ID ile girdikten sonra kişisel bilgilerini güncelleyebilmeli, rezervasyon yaptırabilmeli, güncel rezervasyon ve geçmiş rezervasyon bilgilerine erişebilmeli ve güncel rezervasyonlarında dilediklerini iptal edebilmelidirler. 
Örneğin otel odası rezervasyonu için üyeler (müşteriler) kalmak istedikleri şehri, otelin kalitesini yani yıldız sayısını, oda başına ödemek istedikleri fiyat aralığını, oda özelliklerini ve rezervasyon için başlangıç bitiş tarihlerini belirtirler.

-	Otellerin yıldız sayıları ve otelin her bir odası için fiyat özelliğinin olması zorunludur.
-	Rezervasyon için bu dokümanda belirtilmeyen oda ve otel özelliklerinin projede belirlenmesi ve mümkün olduğunca (en azından 5-6 çeşit) çeşitlendirilmesi gerekmektedir. Örneğin otellerin sağladığı olanakların ve oda özelliklerinin yer alması ve sistemi kullanacak üyelerin bu özellikler üzerinde seçim yapması istenmektedir (Klima, Mini bar, TV, Deniz Manzarası vb…). 
-	Sistem üyenin isteğine uyan her bir oteli üyeye geri bildirir. Üye ise sistem üzerinden rezervasyonuna uygun olarak dönen oteller arasında birini seçerek işlemi tamamlar. Rezervasyonu gerçekleşmişse hangi otelde kalacağı ve diğer rezervasyon bilgilerini görebilmektedir. 
Sistem içerisinde birden fazla otel türü olmalıdır. Örneğin: Pansiyon, butik otel, tatil köyü vb.
-	Ayrıca oteller içerisinde farklı tipte odalar olmalıdır. Örneğin; Tek kişilik oda, İki kişilik oda, İkiz yataklı çift kişilik oda, Üç kişilik oda vb.
Çalışma zamanında gerçekleşebilecek istisnaların belirlenmesi, bu istisnaların her biri için log kayıtlarının tutulması ve işlem akışının kesilmeden devamını sağlamak amacıyla uygun istisna mekanizmalarının yazılım kodunda yer alması beklenmektedir.
-	Log kayıtları basit bir şekilde metin dosyasında tutulabilir. Ancak hatanın çıktığı metot ismi ve exception türünün ilgili log dosyasında olması zorunludur.
Sisteme kayıtlı olan kullanıcıların ve otel kayıtlarının uygun dosya yapılarında (obje serileştirme, xml, json vb…) sistemde saklanması ve sistem başlatıldığında bu dosyalar okunarak gerekli nesnelerin oluşturulup yukarıda tanımlanan işletim senaryolarının gerçekleştirilmesi beklenmektedir.
-	Program her açıldığında daha önceden kaydolmuş kullanıcılar, sistemde bulunan oteller, yapılmış olan tüm rezervasyonlar tekrardan yüklenebilmelidir.
-	Sistem kapatılırken de var olan son durumun dosyaya kaydedilmelidir.
-	Özetle sistem üzerinden gönderilecek programınızda, uygulama yeteneklerini test edebileceğimiz kadar otel, müşteri vb. veri yapılarına ait örnekler hazır bulunmalıdır. Test etmek için bizim sıfırdan veri girişi yapmamız değerlendirme puanlarınızda kesintiye sebep olacaktır.
Ayrıca sistem üzerinden özet bilgilerin verilebildiği bir modül bulunmalıdır:
-	Belirli bir tarih aralığı girildiğinde hangi otelde kaç oda dolu, hangi odalar dolu, kaç kişi ve ne kadara kalıyor bilgileri sunulmalıdır.
-	Bu özet bilgilerin görülebilmesi için sisteme müşteri yerine yönetici hesabıyla girilmesi gerekmektedir.
-	Müşteriler özet bilgiler kısmına erişememektedir.
-	Sisteme otel ekleme, otellere oda ekleme gibi işlemler de sadece yönetici hesabı içerisinde yapılabilmelidir.
-	Diğer taraftan yönetici hesabının rezervasyon talep etme veya iptal etme hakkı bulunmamalıdır.
-	Sistem üzerinde en az iki farklı tasarım deseni kullanılmalıdır. Örneğin; iterator deseni ile otelleri gezmek veya factory deseni ile otel veya odaların yaratılması gibi.

<b>ÖNEMLİ NOT:</b> Proje geliştirme sürecininin ilk safhasında <b>(28 Mayıs 2019 Salı günkü Lab 3 derslerinde hazır olacak şekilde)</b>, yukarıdaki özellikleri özetleyen bir UML diyagramı hazırlamış olmanız ve tamamen bitirilmemiş ve çalışır olmasa da oluşturduğunuz diyagrama uyan bir iskelet yapının geliştirilmiş olması beklenmektedir.

-	Bu kısma ait değerlendirme ağırlığı toplam proje puanınızın %30’unu oluşturacaktır.


Başarılar, iyi çalışmalar 😊
