import adaptador_match.ViewHolderTest
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ciclapp.ItemDeLaLista
import com.example.ciclapp.R
import java.util.*

class adaptador_match(private val mItemDeLaLista: ArrayList<ItemDeLaLista>) :
    RecyclerView.Adapter<ViewHolderTest>() {
    private var mListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        mListener = listener
    }

    class ViewHolderTest(
        itemView: View,
        listener: OnItemClickListener?
    ) :
        RecyclerView.ViewHolder(itemView) {
        var mTextView1: TextView
        var mTextView2: TextView
        var mTextView3: TextView

        init {
            mTextView1 = itemView.findViewById(R.id.MarcaDelTelefono)
            mTextView2 = itemView.findViewById(R.id.ModeloDelTelefono)
            mTextView3 = itemView.findViewById(R.id.Reparabilidad)
            itemView.setOnClickListener {
                if (listener != null) {
                    val position = adapterPosition
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderTest {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.item_lista, parent, false
        )
        return ViewHolderTest(v, mListener)
    }

    override fun onBindViewHolder(holder: ViewHolderTest, position: Int) {
        val currentItem = mItemDeLaLista[position]
        holder.mTextView1.text = currentItem.getmarcaTelefono()
        holder.mTextView2.text = currentItem.getmodeloTelefono()
        holder.mTextView3.text = currentItem.getdescripcion()
    }

    override fun getItemCount(): Int {
        return mItemDeLaLista.size
    }

}