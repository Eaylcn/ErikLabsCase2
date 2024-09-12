Feature: Trendyol Mobil Uygulama Testi
  Scenario: Alışveriş Süreci: Ürün Sepete Eklenip Satın Alınması
    Given Kullanıcı cinsiyet olarak "erkek" seçer ve popup'ı kapatır
    When Kullanıcı kategori butonuna tıklar
    And Kullanıcı erkek kategorisini ve "şort" alt kategorisini seçer
    And Kullanıcı minimum "50" maksimum "250" TL aralığında fiyat filtrelemesi yapar
    And Kullanıcı ürünleri çok satanlar olarak sıralar
    And Kullanıcı sıralanan ürünlerden ilkine tıklar
    And Kullanıcı ürünü varsayılan haliyle sepete ekler
    And Kullanıcı ürünün sayısını arttırır ve fiyatını kontrol eder
    And Kullanıcı sepeti onaylar
    Then Sepeti onayladıktan sonra çıkan popup'ta "Trendyol hesabınız yok mu?" yazısı beklenir