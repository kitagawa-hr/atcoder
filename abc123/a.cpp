#include<iostream>
#include<vector>

using namespace std;
int a,b,c,d,e,k;


template<typename T>
vector<T> vecSlice(vector<T> vec, int a, int b){
    vector<T> v(vec.begin() + a, v.begin() + b);
    return v;
}

int main(){
    cin >> a >> b >> c >> d >>e >> k;
    if (e - a - k > 0){cout<<":("<<endl;}
    else{cout<<"Yay!"<<endl;}
    vector<int> v;
    v.push_back(1);
    v.push_back(2);
    v.push_back(3);
    v.push_back(4);
    auto vec =  vecSlice(v, 1, 3);
    for (auto a: vec){
        cout<<a;
        }
}

