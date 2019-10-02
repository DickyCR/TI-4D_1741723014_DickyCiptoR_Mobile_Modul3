package com.example.communicatingfragment;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.communicatingfragment.Interface.OnMovieClick;

import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MovieFragment extends Fragment implements OnMovieClick {

    private RecyclerView movieListView;
    private MovieAdapter movieAdapter;
    private List<MovieModel> listMovieModel = new ArrayList<>();
    private Context mContext;
    private OnMovieClick listener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dummyData(listMovieModel);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.activity_fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View mView, @Nullable Bundle savedInstanceState){
        super.onViewCreated(mView, savedInstanceState);
        movieListView = mView.findViewById(R.id.listMovie);
        movieListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mContext = getActivity().getApplicationContext();

        listener = this;

        movieAdapter = new MovieAdapter(listMovieModel,getActivity().getSupportFragmentManager(),mContext,listener);
        movieListView.setAdapter(movieAdapter);
        movieAdapter.SetListModel(listMovieModel);
    }


    private void dummyData(List<MovieModel> ListMovieModel){

        ListMovieModel.add(new MovieModel("Gundala", R.drawable.gundala, "Action", "96", "Sancaka hidup di jalanan sejak ditinggal " +
                "ayah dan ibunya. Menghadapi hidup yang keras, Sancaka belajar untuk bertahan hidup dengan tidak peduli dengan orang lain dan hanya mencoba untuk " +
                "mendapatkan tempat yang aman bagi dirinya sendiri. Ketika situasi kota semakin tidak aman dan ketidakadilan merajalela di seluruh negeri, " +
                "Sancaka harus buat keputusan yang berat, tetap hidup di zona amannya, atau keluar sebagai Gundala untuk membela orang-orang yang ditindas."));

        ListMovieModel.add(new MovieModel("Pengabdi setan", R.drawable.pengabdisetan, "Horor", "93", "Setelah sakit aneh selama 3 tahun, " +
                "Ibu akhirnya meninggal dunia. Bapak lalu memutuskan untuk kerja di luar kota meninggalkan anak-anak. Tak lama kemudian, " +
                "anak-anak merasa bahwa Ibu kembali berada di rumah. Situasi semakin menyeramkan ketika mereka mengetahui bahwa Ibu datang " +
                "lagi tidak sekedar untuk menjenguk, tapi untuk menjemput mereka."));

        ListMovieModel.add(new MovieModel("Habibie & Ainun", R.drawable.habibiainun, "Drama", "97", "Rudy Habibie seorang genius ahli pesawat " +
                "terbang yang punya mimpi besar: berbakti kepada bangsa Indonesia dengan membuat pesawat terbang untuk menyatukan Indonesia. Sedangkan Ainun adalah seorang " +
                "dokter muda cerdas yang dengan jalur karier terbuka lebar untuknya.\n" + "\n" + "Pada tahun 1962, dua kawan SMP ini bertemu lagi di Bandung. Habibie jatuh " +
                "cinta seketika pada Ainun yang baginya semanis gula. Tapi Ainun, dia tak hanya jatuh cinta, dia iman pada visi dan mimpi Habibie. Mereka menikah dan terbang " +
                "ke Jerman.\n" + "\n" + "Punya mimpi tak akan pernah mudah. Habibie dan Ainun tahu itu. Cinta mereka terbangun dalam perjalanan mewujudkan mimpi. Dinginnya " +
                "salju Jerman, pengorbanan, rasa sakit, kesendirian serta godaan harta dan kuasa saat mereka kembali ke Indonesia mengiringi perjalanan dua hidup menjadi satu. "));

        ListMovieModel.add(new MovieModel("Laskar Pelangi", R.drawable.laskarpelangi, "Drama", "95", "Film Laskar Pelangi merupakan karya adaptasi " +
                "dari buku Laskar Pelangi yang ditulis oleh Andrea Hirata. Bercerita tentang kisah 11 anak asal bangka belitung yang bersekolah di tempat yang kurang layak namun mereka mampu" +
                "membuktikan bahwa prestasi tidak hanya datang dari latar orang berada"));

        ListMovieModel.add(new MovieModel("My Stupid Boss", R.drawable.stupidboss, "Komedi", "94", "My Stupid Boss merupakan sebuah film komedi " +
                "Indonesia yang bercerita mengenai kekesalah seorang pegawai terhadap bossnya yang memiliki tingkah unik bin aneh yang membuat komedi "));

        ListMovieModel.add(new MovieModel("Comic 8", R.drawable.comic8, "Komedi", "95", "Comic 8 adalah film aksi-komedi Indonesia yang " +
                "disutradarai oleh Anggy Umbara bercerita mengenai 8 orang perampok bank yang melakukan aksinya namun berisi dialog dialog komedi"));

        ListMovieModel.add(new MovieModel("Sang kiai", R.drawable.sangkiai, "Religi", "95", "Kisah tentang penjajahan Jepang Tahun 1942 yang melarang" +
                " pengibaran bendera merah putih, melarang lagu Indonesia Raya dan memaksa rakyat Indonesia untuk melakukan Sekerei. Tokoh besar agamis saat itu KH Hasyim Asyari " +
                "(Ikranagara) menolak melakukan Sekerei karena tindakan itu menyimpang dari aqidah agama Islam. "));

        ListMovieModel.add(new MovieModel("Keluarga cemara", R.drawable.keluargacemara, "Religi", "95", "ABAH, sangat ingin bertahan setelah rumah " +
                "dan pasca hartanya disita oleh debt collector untuk membayar hutang perusahaan yang disebabkan oleh kakak iparnya, dengan cara pindah sementara ke rumah di desa " +
                "terpencil di Jawa Barat. Rumah itu merupakan rumah masa kecilnya, sebuah warisan dari ayahnya. Namun dia menghadapi kesulitan karena kasusnya kalah di pengadilan dan " +
                "keluarganya terancam selamanya hidup dalam kemiskinan di desa itu. "));
    }


    @Override
    public void onItemClick(MovieModel movieModel, int position) {
        if (!MainActivity.isTwoPane){
            Intent intent = new Intent(getContext(),DetailActivity.class);
            intent.putExtra("movie",movieModel);
            startActivity(intent);
        }else {
            getFragmentManager().beginTransaction().replace(R.id.frameLayout_land,DetailFragment.newInstance(movieModel)).commit();
        }
    }
}
