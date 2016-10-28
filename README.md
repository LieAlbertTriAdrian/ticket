# Tugas 1IF4050 Pembangunan Perangkat Lunak berbasis Service


## Deskripsi Singkat

Tricket merupakan suatu platform marketplace untuk acara live yang menyediakan pelayanan pada orang-orang untuk menemukan dan membuat acara (events). Platform ini membantu event organizer untuk membuat acara dan menjual tiket. Selain itu, platform ini juga membantu pembeli untuk mengetahui acara sesuai dengan waktu yang mereka inginkan dan kemudian membeli tiket untuk acara yang menarik bagi mereka.

## Anggota Tim

 * Ivan Andrianto 13513039
 * Lie, Albert Tri Adrian 13513076
 * Fitra Rahmamuliani 13513095


## Pembagian Tugas

 * Ivan Andrianto - Event Service
 * Lie, Albert Tri Adrian - Ticket Service + Transaksi Service
 * Fitra Rahmamuliani - Transaksi Service

## Prosedur Instalasi

 * Open project dengan menggunakan IDE Netbeans
 * Install server Glassfish (apabila belum terinstall)
 * Tekan tombol 'Run Project'
 * Klik kanan pada service yang ingin dicoba, pilih Test Web Service

## Petunjuk Pengerjaan

 * Buatlah Group pada gitlab.
 * Tambahkan anggota tim pada Group tsb dan akun @yudis
 * Fork repository ini dengan kelompok yang telah dibuat.
 * Ubah hak akses repository hasil Fork anda menjadi private.
 * Silakan commit pada repository anda (hasil fork).
 * Lakukan berberapa commit dengan pesan yang bermakna, contoh: `fix css`, `create post done`, jangan seperti `final`, `benerin dikit`. Disarankan untuk tidak melakukan commit dengan perubahan yang besar karena akan mempengaruhi penilaian (contoh: hanya melakukan satu commit kemudian dikumpulkan). Sebaiknya commit dilakukan setiap ada penambahan fitur. **Commit dari setiap anggota tim akan mempengaruhi penilaian.** Jadi, setiap anggota tim harus melakukan commit yang berpengaruh terhadap proses pembuatan aplikasi.
 * Edit file readme ini semenarik mungkin (gunakan panduan Markdown language), diperbolehkan untuk merubah struktur dari readme ini.
 * Pada Readme
   * terdapat deskripsi singkat dari aplikasi
   * penjelasan mengenai pembagian tugas masing-masing anggota (lihat formatnya pada bagian pembagian tugas)
   * prosedur instalasi
 * Merge request dari repository anda ke repository ini dengan format Nama kelompok - NIM terkecil - Nama Lengkap dengan NIM terkecil sebelum Jumat, 28 Oktober 2016 17.00.


## Tools

 * Untuk backend, wajib menggunakan **Java Web Technology** dengan menggunakan JAX-WS
 * Gunakan **MySQL** untuk menyimpan data.
 * Struktur Folder
   * `docs` meletakkan semua dokumentasi Business & Logical Design dalam bentuk Wiki
   * `src` soruce code java
   * `lib` Java Library yang dibutuhkan oleh Java Project
   * `build` build terhadap source code
   * `wsdl` letak dari WSDL
   * `test` test cases/codes
   * Untuk melakukan testing menggunakan SOAP-UI, dan semua kasus uji (SOAP-UI Project) di letakkan di `test\soap-ui`
 
