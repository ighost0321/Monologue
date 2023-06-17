package com.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MemoService {

	private final MemoRepository memoRepository;

	public MemoService(MemoRepository memoRepository) {
		this.memoRepository = memoRepository;
	}

	public void save(Memo memo) {
		memoRepository.save(memo);
	}

	public List<String> findAll() {
		return memoRepository.findAll().stream().map(Memo::getWords).toList();
	}

}
