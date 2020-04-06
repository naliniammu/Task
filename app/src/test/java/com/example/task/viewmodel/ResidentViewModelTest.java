package com.example.task.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;

import com.example.task.adapter.ResidentAdapter;
import com.example.task.db.Resident;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;
import io.reactivex.schedulers.TestScheduler;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ResidentAdapter.class,ResidentViewModel.class})

public class ResidentViewModelTest {
    @Mock
    ResidentViewModel residentViewModel;
    @Mock
    ResidentAdapter residentAdapter;
    @Mock
    ArrayList<Resident> residents=new ArrayList<Resident>();
    String ob1, ob2,ob3;

    @Mock
    private MutableLiveData<List<Resident>> mResidentList= new MutableLiveData<>();

    @Mock
    Observer<Resident> observer=new Observer<Resident>() {
        @Override
        public void onChanged(Resident resident) {

        }
    };

    @Before
    public void setUp() throws Exception {
        PowerMockito.mockStatic(ResidentViewModel.class);

    }

    private Resident dummyList() {
        Resident mResident = new Resident();
     ob1="Test";
     ob2="21/7/92";
     ob3="Delhi";

        return mResident;


    }
    @Test
  public   void ResidentAddTest() {
        TestScheduler testScheduler=new TestScheduler();
        PowerMockito.when(residentViewModel.getResidentList()).thenReturn(null);
        residentViewModel.showResidents();
        PowerMockito.when(residentViewModel.showResidents()).thenReturn(dummyList());

    }



}